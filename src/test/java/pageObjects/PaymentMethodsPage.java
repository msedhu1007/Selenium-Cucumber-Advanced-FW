package pageObjects;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class PaymentMethodsPage extends BasePage{
	
	BaseClass bc = new BaseClass();
	AccountHomePage ahp = new AccountHomePage();
	By txtName = By.id("name");
	By txtCardNumber = By.id("card");
	By lstExpirationMonth = By.id("month");
	By lstExpirationYear = By.id("year");
	By chkboxDefault = By.className("div.checkbox.make-default-payment");
	By btnSaveforFutureOrders = By.id("submit-payment-form");
	By rdoAddNewAddress = By.cssSelector("label[for='new-billing-address']");
	By rdoCurrentAddress = By.cssSelector("label[for='address-radio-1']");
	By linkEditDefaultPayment = By.xpath("(//a[@class='edit-link'])[1]");
	By btnUpdatePaymentMethod = By.cssSelector("input#submit-payment-form");
	By btnDeletePaymentMethod = By.xpath("//a[text()='Delete Payment Method']");
	By btnCancel = By.xpath("//a[contains(text(),'Cancel')]");
	By btnDelete = By.id("submit");
	
	
	
	public void navigateToPaymentDetailsPg() {
		bc.mouseHover(linkHelloGuest);
		bc.JSClick(linkMyAccount);
		bc.click(ahp.lnkPaymentMethod);
		bc.WaitForElementPresent(txtName, 20);
	}
	
	public void addPaymentDetails(String name, String cardNo, String month, String year) {
		bc.WaitForElementPresent(txtName, 20);
		bc.SendKeys(txtName, name);
		bc.SendKeys(txtCardNumber, cardNo);
		bc.SelectTextByValue(lstExpirationMonth, month);
		bc.SelectTextByValue(lstExpirationYear, year);
		bc.click(btnSaveforFutureOrders);
	}
	
	public void deletePaymentDetails() throws Exception {
		bc.WaitForElementPresent(linkEditDefaultPayment, 20);
		bc.click(linkEditDefaultPayment);
		bc.WaitForElementPresent(btnDeletePaymentMethod, 15);
		bc.click(btnDeletePaymentMethod);
		bc.WaitForElementPresent(btnDelete, 10);
		bc.click(btnDelete);
	}
	
	
	public Boolean isAllfieldsDisplayed() {
		if(bc.isDisplayed(txtName) && (bc.isDisplayed(txtCardNumber)) && (bc.isDisplayed(lstExpirationMonth)) && (bc.isDisplayed(lstExpirationYear))) {
			return true;
		}
		else {
			return false;
		}
				
	}
	
	
	public Boolean isAllFieldsDisplayed() {
		Boolean strResult;
		strResult = bc.isDisplayed(txtName) && (bc.isDisplayed(txtCardNumber)) && (bc.isDisplayed(lstExpirationMonth)) && (bc.isDisplayed(lstExpirationYear)) ? true : false ;
		return strResult;		
	}
}
