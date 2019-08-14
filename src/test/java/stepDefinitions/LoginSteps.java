package stepDefinitions;
import cucumber.api.java.en.*;
import io.cucumber.datatable.DataTable;
import pageObjects.*;
import utilities.BaseClass;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps {
	HomePage homepage = new HomePage();
	LoginPage loginpage = new LoginPage();
	BaseClass bc = new BaseClass();
	AccountHomePage accountpage = new AccountHomePage();
	PaymentMethodsPage pmp = new PaymentMethodsPage();
	AddressManagerPage amp = new AddressManagerPage();
	AccountHomePage ahp = new AccountHomePage();
	HomePage hp = new HomePage();
	
	@Given("^the user navigate to the Login page$")
	public void i_navigate_to_the_Login_page() throws Throwable {
		homepage.navigate_to_LoginPage();
	}

	@When("^the user login with following credentials$")
	public void i_login_with_email_and_Password(DataTable tblValues) {
		List<String> list = tblValues.asList(String.class);
		loginpage.waitforLoginPageToOpen();
		loginpage.login(list.get(0), list.get(1));
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() {
		accountpage.waitforAccountHomePagetoOpen();
	//	bc.getCookies();
		assertThat(accountpage.isAccountHomePageOpened()).isTrue();
	}
	
	@Then("^login should not be successful$")
	public void login_shouldnot_be_successful() {
		assertThat(homepage.getErrorMsg().contains("We're unable to find a match for this username/password combination"));
	}


	@And("^the user logs in to the application with following credentials$")
	public void navigateAndlogin(DataTable tblValues){
		homepage.navigate_to_LoginPage();
		List<String> list = tblValues.asList(String.class);
		loginpage.waitforLoginPageToOpen();
		loginpage.login(list.get(0), list.get(1));
	}


	@And("^the user moves to the Home page$")
	public void userMoveToHomePg() throws Exception{
		hp.handleModal();
		ahp.navigateToHomePage();
		pmp.navigateToPaymentDetailsPg();
		pmp.deleteAllpayments();
		amp.navigatetoAddressMgr();
		amp.deleteAllAddress();
	}





}
