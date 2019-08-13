package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AccountHomePage;
import pageObjects.ShoppingBagPage;

import static org.assertj.core.api.Assertions.assertThat;


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
        assertThat(sbp.getHeadingAndMessage()).contains(message);
    }

    @Then("^option to continue shopping$")
    public void continueShopping() {
        assertThat(sbp.isContinueShoppingLinkDisplayed()).as("Continue Shopping link ").isTrue();
    }


    @Then("^the user is informed to sign in to proceed with StretchPay$")
    public void userInformedToSign() {
        assertThat(sbp.verifyErrorMessage().equalsIgnoreCase("Please sign in, create an account or remove the StretchPay™ item(s) to proceed with your order."));
    }

}
