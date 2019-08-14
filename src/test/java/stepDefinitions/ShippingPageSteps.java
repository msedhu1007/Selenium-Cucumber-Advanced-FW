package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import pageObjects.BillingPage;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import pageObjects.*;

public class ShippingPageSteps {

    ShippingPage sp = new ShippingPage();
    ReviewOrderPage rop = new ReviewOrderPage();
    BillingPage bp = new BillingPage();
    OrderResponsePage orp = new OrderResponsePage();

    @And("^the user enters the Shipping address and continues to Billing$")
    public void enterShippingAddress_Billing(DataTable tblValues) {
        List<String> list = tblValues.asList(String.class);
        sp.enterShippingAddress(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
        sp.selectSuggestedAddress();
    }



    @Then("^the user should have only Standard Delivery option$")
    public void verifyDeliveryOption() {
        assertThat(sp.isOnlyStandardDeliveryDisplayed()).isTrue();
    }


    @And("^user changes the shipping address$")
    public void userChangesShippingAddress(DataTable tblValues) throws Exception {
        List<String> list = tblValues.asList();
        rop.clickEditShippingAddress();
        sp.waitForShippingPageToOpen();
        sp.enterShippingAddress(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
        sp.selectSuggestedAddress();
    }


	@Then("^the order is not successfully placed with the message Authorization Declined$")
	public void authorizationDeclinedWithMessage(){
		assertThat(sp.getErrorMsg()).startsWith("The credit card").contains("could not be authorized for payment: .").doesNotContain("You will receive an email confirmation soon at");

	}



    @Then("^the Sales Tax gets computed based on the new Shipping address$")
    public void VerifySalesTaxComputed() throws Exception {
        double salestax = (Double.parseDouble(bp.getSubTotal()) + Double.parseDouble(bp.getStdDelivery()) - Double.parseDouble(bp.getOrderDiscounts()))* (9.25 / 100);
        System.out.println(salestax);
        double val = Math.round(salestax * 100.0) / 100.0;
        assertThat(Double.parseDouble(bp.getSalesTax())).isEqualTo(val);

    }


    @Then("^the order should be placed and shipping cost should be added$")
    public void verifyOrderIsSuccessfulAndShippingCost(){
        System.out.println(orp.getOrderSuccessConfirmation());
        System.out.println(orp.getShippingCost());
        assertThat(orp.getOrderSuccessConfirmation().contains("You will receive an email confirmation soon at")).isTrue();
        assertThat(orp.getShippingCost().contains("$7")).isTrue();
    }


}
