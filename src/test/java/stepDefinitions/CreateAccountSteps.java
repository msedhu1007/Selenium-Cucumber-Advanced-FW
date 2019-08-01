package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import pageObjects.AccountHomePage;
import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import pageObjects.ShippingPage;
import pageObjects.ShoppingBagPage;
import utilities.BaseClass;


public class CreateAccountSteps implements En{
	BaseClass bc = new BaseClass();
	CreateAccountPage createaccountpg = new CreateAccountPage();
	AccountHomePage ahp = new AccountHomePage();
	HomePage hp = new HomePage();
	ProductDetailsPage pdp = new ProductDetailsPage();
	ShoppingBagPage sbp = new ShoppingBagPage();
	LoginPage lp = new LoginPage();
	ShippingPage sp = new ShippingPage();

	
	@When("^the user creates an account with existing email address$")
	public void userCreatesAccountExistingEmail(DataTable tableData) {
		List<String> data = tableData.asList();
		createaccountpg.CreateAccount(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));
	}
	
	
	@Then("^Error message \"([^\"]*)\" appears$")
	public void verifyErrorMsg(String msg) throws Exception {
		String application_errmsg = createaccountpg.getErrorMsg().substring(0,createaccountpg.getErrorMsg().length()-1);
		assertThat(application_errmsg).isEqualTo(msg);	
	}
	

	@Then("^the Account should get created successfully$")
	public void accountShouldGetCreated() {
		hp.handleModal();
		assertThat(ahp.getHeading().contains("Hello")).isTrue();
		assertThat(ahp.getSignedInMsg().contains("You're signed in as")).isTrue();
	}
	
	
	@And("^the user navigates to Bag screen and creates account with existing email$")
	public void userNavigatesToBagCreateAccount(DataTable tblValues) {
		pdp.hoverOverBag();
		pdp.clickBag();
		sbp.clickCheckOut();
		lp.GuestCreateAccount();
		List<String> data = tblValues.asList();
		createaccountpg.CreateAccount(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5));	
	}

	
	@And("^the user navigates to Bag screen and creates account with new email$")
	public void createAccountNewEmail(DataTable tblValues) throws Throwable {
		pdp.hoverOverBag();
		pdp.clickBag();
		sbp.clickCheckOut();
		lp.GuestCreateAccount();
		List<String> data = tblValues.asList();
	//	String newEmail = bc.Random_StringGenerator(6) + bc.Random_NumberGenerator(5)+"@gmail.com";
		String newEmail = bc.generateRandomAlphanumericString(10)+"@gmail.com";
		createaccountpg.CreateAccount(data.get(0), data.get(1), newEmail, data.get(3), data.get(4), data.get(5));
	}
	
	
	@Then("^the Account should get created and user should move to Shipping page$")
	public void ValidateAccountCreation() {
		sp.waitForShippingPageToOpen();
		assertThat(sp.isShippingPageOpen()).isTrue();
	}
	
	@And("^the user creates an account with new email address$")
	public void createNewAccount(DataTable tblValues) {
		List<String> data = tblValues.asList();
		String newEmail = bc.generateRandomAlphanumericString(10)+"@gmail.com";
		createaccountpg.CreateAccount(data.get(0), data.get(1), newEmail, data.get(3), data.get(4), data.get(5));

	}
}
