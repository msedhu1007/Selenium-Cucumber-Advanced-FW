package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;


public class LoginPage extends BasePage{

	BaseClass bc = new BaseClass();

	By textEmailAddress = By.id("username");
	By textPassword = By.id("password");
	By btnSignIn = By.id("kc-login");
	By chkboxKeepMeSignedIn = By.id("rememberMe");
	By btnGuestcheckOut = By.xpath("//a[contains(text(),'Guest Checkout')]");
	By btnCreateAnAccount = By.xpath("//a[contains(text(),'Create an Account')]");
	By btnCreateAnAccountGuestCheckout = By.cssSelector("div.already-new-msg + a");


	public void login(String email, String pwd) {
		bc.SendKeys(textEmailAddress, email);
		bc.SendKeys(textPassword, pwd);
		bc.selectChkbox(chkboxKeepMeSignedIn);
		bc.click(btnSignIn);
	}


	public boolean isLoginPageOpen(){
		return bc.isDisplayed(textEmailAddress);
	}


	public void waitforLoginPageToOpen() {
		bc.waitUntillElementToBeVisible(textPassword,20);
	}

	public void doGuestCheckOut() {
		bc.WaitForElementPresent(btnGuestcheckOut, 15);
		bc.click(btnGuestcheckOut);
	}
	
	public void GuestCreateAccount() {
		bc.WaitForElementPresent(btnCreateAnAccountGuestCheckout, 15);
		bc.click(btnCreateAnAccountGuestCheckout);
	}


}
