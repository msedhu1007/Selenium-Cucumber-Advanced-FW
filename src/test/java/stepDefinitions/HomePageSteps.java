package stepDefinitions;
import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.AccountHomePage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ProductListPage;
import utilities.BaseClass;

public class HomePageSteps {
	
	AccountHomePage ahp = new AccountHomePage();
	HomePage hp = new HomePage();
	ProductDetailsPage pdp = new ProductDetailsPage();
	ProductListPage plp = new ProductListPage();
	 BaseClass bc = new BaseClass();
	 
	@Given("^the user navigates to the home page$")
	public void i_navigate_to_the_Login_page() throws Throwable {
		hp.handleModal();
		ahp.navigateToHomePage();
	}
	
	
	@Then("^the user should see Search field with the text \"([^\"]*)\"$")
	public void verify_searchfield_text(String text) {
		hp.handleModal();
		assertThat(ahp.isSearchFieldPresent()).isTrue();
	}
	
	@Given("^the user navigate to the Create Account page$")
	public void user_navigates_CreateAccountPage() {
		bc.implicitWait(0);
		hp.navigate_to_CreateAccountPage();
	}
	
	@And("^the user selects an item and Adds to Bag$")
	public void user_selects_item() throws Exception {
		hp.handleModal();
		hp.selectJewelry();
		plp.selectFirstProduct();	
		pdp.selectAnySize();
		pdp.addToBag();
		
	}

}
