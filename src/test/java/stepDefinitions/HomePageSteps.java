package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.*;
import utilities.BaseClass;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps {

    AccountHomePage ahp = new AccountHomePage();
    HomePage hp = new HomePage();
    ProductDetailsPage pdp = new ProductDetailsPage();
    ProductListPage plp = new ProductListPage();
    BaseClass bc = new BaseClass();
    PaymentMethodsPage pmp = new PaymentMethodsPage();

    @Given("^the user navigates to the home page$")
    public void i_navigate_to_the_home_page() throws Throwable {
        hp.handleModal();
        //	bc.setCookies();
        ahp.navigateToHomePage();
    }


    @Given("^the user navigates to the Home page$")
    public void i_navigate_to_the_Home_page() throws Throwable {
        hp.handleModal();
        ahp.navigateToHomePage();
        pmp.navigateToPaymentDetailsPg();
        pmp.deleteAllpayments();
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
        plp.selectRingsFirstProduct();
        pdp.selectAnySize();
        pdp.addToBag();

    }


    @And("^the user selects a Stretch pay item and Adds to Bag$")
    public void selectStretchPayItem() throws Exception {
        hp.handleModal();
        hp.selectJewelryTypes("Necklaces");
        bc.sleep(3);
        hp.clickStretchPay();
        plp.selectFirstProduct();
        pdp.selectAnySize();
        pdp.selectStretchPay();
        pdp.addToBag();
    }

}
