package pageObjects;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class BillingPage {

	By txtName = By.id("name");
	By txtCardNo = By.id("card");
	By lstExpirationMonth = By.id("month");
	By lstExpirationYear = By.id("year");
	By txtCVV = By.id("cvv");
	By chkboxSameShippingAddress = By.id("same-as-shipping");
	By txtEmail = By.id("email-same-as-shipping");
	By btnReviewYourOrder = By.xpath("(//button[contains(text(),'Review Your Order')])[2]");
	By txtFirstName = By.id("first-name");
	By txtLastName = By.id("last-name");
	By txtPhone = By.id("phone");
	By txtEmailAddress = By.id("email");
	By txtAddressOne = By.id("address-1");
	By txtAddressTwo = By.id("address-2");
	By txtCity = By.id("city");
	By lstCountry = By.id("country");
	By lstState = By.id("state");
	By txtZip = By.id("zip");
	By btnReviewYourOrderOne = By.xpath("(//button[contains(text(),'Review Your Order')])[1]");
	BaseClass bc = new BaseClass();

	public void fillCardInfo(String name, String cardNo, String expMonth, String expYear, String cvv) throws Exception  {
		bc.WaitForElementPresent(txtName, 15);
		bc.setText(txtName, name);
		bc.setText(txtCardNo, cardNo);
		bc.SelectTextByValue(lstExpirationMonth, expMonth);
		bc.SelectTextByValue(lstExpirationYear, expYear);
		bc.setText(txtCVV, cvv);
	}


	public void selectSameAsShippingAddressFillEmail(String email) {
		bc.selectChkbox(chkboxSameShippingAddress);
		bc.SendKeys(txtEmail, email);
	}

	public void reviewOrder() {
		bc.WaitForElementPresent(btnReviewYourOrder, 10);
		bc.click(btnReviewYourOrder);
	}

	public void enterBillingAddress(String fName, String lName, String phone, String address1, String address2, String city, String country, String state, String zipcode) throws Exception {
		bc.click(chkboxSameShippingAddress);
		bc.WaitForElementPresent(txtFirstName, 15);
		bc.SendKeys(txtFirstName, fName);
		bc.SendKeys(txtLastName, lName);
		bc.SendKeys(txtPhone, phone);
		bc.SendKeys(txtAddressOne, address1);
		bc.SendKeys(txtAddressTwo, address2);
		bc.SendKeys(txtCity, city);
		bc.SelectTextByVisibleText(lstCountry, country);
		bc.SelectTextByValue(lstState, state);
		bc.SendKeys(txtZip, zipcode);
		bc.sleep(2);
		bc.click(btnReviewYourOrderOne);
	}


}
