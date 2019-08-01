package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageObjects.AccountHomePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.BaseClass;

public class LoginSteps {
	HomePage homepage = new HomePage();
	LoginPage loginpage = new LoginPage();
	BaseClass bc = new BaseClass();
	AccountHomePage accountpage = new AccountHomePage();
	

	
	@Given("^the user navigate to the Login page$")
	public void i_navigate_to_the_Login_page() throws Throwable {
		homepage.navigate_to_LoginPage();
	}

	@When("^the user login with following credentials$")
	public void i_login_with_email_and_Password(DataTable tblValues) throws Throwable {
		List<String> list = tblValues.asList(String.class);
		loginpage.waitforLoginPageToOpen();
		loginpage.login(list.get(0), list.get(1));
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
		accountpage.waitforAccountHomePagetoOpen();
		assertThat(accountpage.isAccountHomePageOpened()).isTrue();
	}
	
	@Then("^login should not be successful$")
	public void login_shouldnot_be_successful() {
		assertThat(homepage.getErrorMsg().contains("We're unable to find a match for this username/password combination"));
	}



}
