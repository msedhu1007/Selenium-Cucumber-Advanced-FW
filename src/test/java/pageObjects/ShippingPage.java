package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class ShippingPage {

	By txtFirstName = By.id("first-name");
	By txtLastName = By.id("last-name");
	By txtPhone = By.id("phone");
	By txtAddressOne = By.id("address-1");
	By txtAddressTwo = By.id("address-2");
	By txtCity = By.id("city");
	By lstCountry = By.id("country");
	By lstState = By.id("state");
	By txtZip = By.id("zip");
	By btnContinueToBilling = By.xpath("(//button[contains(text(),'Continue To Billing')])[1]");
	By btnContinueBilling = By.id("method-submit");
	By chkboxStdDelivery = By.cssSelector("label[for='shipping-0']");
	By chkbox2ndBusinessDay = By.cssSelector("label[for='shipping-2']");
	By chkboxNextBusinessDay = By.cssSelector("label[for='shipping-1']");
	By chkbox3rdBusinessDay = By.cssSelector("label[for='shipping-3']");
	By btnUseThisAddress = By.id("use-avs-address");
	By btnEnterANewAddress = By.cssSelector("button.button.secondary.expand");
	By rdoSuggestedAddress = By.cssSelector("input#suggested + label");
	By rdoEnteredAddress = By.id("entered");

	BaseClass bc = new BaseClass();
	
	public void enterShippingAddress(String fName, String lName, String phone, String address1, String address2, String city, String country, String state, String zipcode) {
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
		bc.click(btnContinueToBilling);
	}
	
	public void selectSuggestedAddress() {
		bc.WaitForElementPresent(rdoSuggestedAddress, 20);
		bc.click(rdoSuggestedAddress);
		bc.click(btnUseThisAddress);
	}
	
	public void selectEnteredAddress() {
		bc.click(rdoEnteredAddress);
		bc.click(btnUseThisAddress);
	}
	
	public Boolean isShippingPageOpen() {
		return bc.isDisplayed(btnContinueBilling);
	}
	
	public void waitForShippingPageToOpen() {
		bc.WaitForElementPresent(btnContinueBilling, 25);
	}

	public void clickContinueToBilling(){
	//	bc.click(btnContinueToBilling);
		bc.click(btnContinueBilling);
	}

	public Boolean isOnlyStandardDeliveryDisplayed(){
			if(bc.isDisplayed(chkboxStdDelivery) && !bc.isDisplayed(chkboxNextBusinessDay) && !bc.isDisplayed(chkbox2ndBusinessDay) && !bc.isDisplayed(chkbox3rdBusinessDay)){
				return true;
			}
			else{
				return false;
			}
	}

}
