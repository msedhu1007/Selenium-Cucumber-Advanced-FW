package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AccountHomePage;
import pageObjects.ShoppingBagPage;


public class ShoppingBagSteps {
	
	ShoppingBagPage sbp = new ShoppingBagPage();
	AccountHomePage ahp = new AccountHomePage();
	
	@When("^user navigates to Shopping bag screen$")
	public void navigateToShoppingBagPage() {
		ahp.handleEmailModal();
		sbp.navigateToShoppingBagPage();
		sbp.waitforPageToOpen();
	}
	
	@And("^user should be displayed \"([^\"]*)\"$")
	public void verifyShoppingBagScreen(String message) {
		assertThat(sbp.getHeadingAndMessage().get(1)).contains(message);
	}
	
	@Then("^option to continue shopping$")
	public void continueShopping() {
		assertThat(sbp.isContinueShoppingLinkDisplayed()).as("Continue Shopping link ").isTrue();
	}

}
