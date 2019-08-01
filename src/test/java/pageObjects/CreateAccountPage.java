package pageObjects;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class CreateAccountPage extends BasePage{
	
	BaseClass bc = new BaseClass();
	
	By txtFirstName = By.id("firstName");
	By txtLastName = By.id("lastName");
	By txtEmail = By.id("email");
	By txtPhone = By.id("user.attributes.phoneNumber");
	By txtPassword = By.id("password");
	By txtConfirmPassword = By.id("password-confirm");
	By btnCreateAccount = By.cssSelector("input.btn.btn-primary.btn-block.btn-lg");
	By btnSignIn = By.className("btn btn-secondary btn-block btn-lg");
	By errormsg = By.xpath("//div[@class='alert alert-error']/span[2]");
	
	
	public void CreateAccount(String firstNm, String lastNm, String email, String phNumber, String password, String confirmPassword) {
		bc.WaitForElementPresent(txtFirstName, 20);
		bc.SendKeys(txtFirstName, firstNm);
		bc.SendKeys(txtLastName, lastNm);
		bc.SendKeys(txtEmail, email);
		bc.SendKeys(txtPhone, phNumber);
		bc.SendKeys(txtPassword, password);
		bc.SendKeys(txtConfirmPassword, confirmPassword);
		bc.click(btnCreateAccount);
	}
	
	public String getErrorMsg() {
		bc.WaitForElementPresent(errormsg, 10);
		return bc.getText(errormsg);
	}

}
