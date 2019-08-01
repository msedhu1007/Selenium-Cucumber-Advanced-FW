package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;
import utilities.Log;

public class AccountHomePage extends BasePage{

	BaseClass bc = new BaseClass();

	By linkMyAccount = By.xpath("//a[text()='My Account']");
	By headingAccountHome = By.cssSelector("div.account-heading h1");
	By linkHome = By.xpath("//a[text()='Home']");
	By linkQuickBuy = By.xpath("//a[contains(text(),'QuickBuy')]");
	By emailModal = By.className("div.email-modal");
	By txtOrderNumber = By.id("order-id");
	By imgJtvLogo = By.cssSelector("div.masthead-section.logo a");
	By txtHeading = By.cssSelector("div.account-heading p");
	By lnkPaymentMethod = By.cssSelector("a[href*='payment.jsp'][ role='menuitem']");
	By eleShippingAddress = By.xpath("(//p[@class='address'])[2]");
	By eleBillingAddress = By.xpath("(//p[@class='address'])[1]");
	By lnkManageShippingAddress = By.xpath("(//a[contains(@href,'address.jsp')])[3]");
	By lnkManageBillingAddress = By.xpath("(//a[contains(@href,'address.jsp')])[2]");
	

	public boolean isAccountHomePageOpened(){
		return bc.getText(headingAccountHome).contains("Hello");	
	}

	public void waitforAccountHomePagetoOpen() {
		bc.WaitForElementPresent(linkMyAccount,10);	
	}

	public void navigateToHomePage() {
		//bc.click(imgJtvLogo);
		try {
			bc.getDriver().findElement(imgJtvLogo).click();
		}
		catch(Exception e) {
			handleModal();
		}
	}

	
	public String getHeading() {
		bc.WaitForElementPresent(headingAccountHome, 30);
		return bc.getText(headingAccountHome);
	}
	
	
	public String getSignedInMsg() {
		return bc.getText(txtHeading);
	}


	public void navigateToQuickBuyPage() {
		bc.JSClick(linkQuickBuy);
	}


	public void handleEmailModal() {
		if(bc.findAllElements(icnClose).size()>0) {
			bc.ignoreClick(icnClose);
			Log.info("Email modal handled");
		}
	}

	public void waitforPageToUnload() {
		bc.waitForElementToDisappear(txtOrderNumber);
	}


	public void clickMyAccount(){
		bc.waitUntillElementToBeVisible(linkMyAccount, 20);
		bc.JSClick(linkMyAccount);
	}

	public Boolean chkShippingAddressIsEmpty(){
		return bc.findAllElements(eleShippingAddress).size()>0 ? false : true;
	}


	public Boolean chkBillingAddressIsEmpty(){
		return bc.findAllElements(eleBillingAddress).size()>0 ? false : true;
	}


	public void clickShippingAddress(){
		bc.click(lnkManageShippingAddress);
	}
}
