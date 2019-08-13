package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import pageObjects.BillingPage;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingPage;
import pageObjects.ShoppingBagPage;

import java.text.DecimalFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ReviewOrderSteps {
    ReviewOrderPage ro = new ReviewOrderPage();
    ShippingPage sp = new ShippingPage();
    BillingPage bp = new BillingPage();
    ShoppingBagPage sbp = new ShoppingBagPage();


    @And("^the user reviews and places the Order$")
    public void reviewAndPlaceOrder(DataTable tblvalues) {
        List<String> list = tblvalues.asList();
        assertThat(ro.getShippingAddress().contains(list.get(0)));
        assertThat(ro.getShippingAddress().contains(list.get(1)));
        assertThat(ro.getShippingAddress().contains(list.get(2)));
        assertThat(ro.getShippingAddress().contains(list.get(3)));
        assertThat(ro.getShippingAddress().contains(list.get(4)));
        assertThat(ro.getShippingAddress().contains(list.get(5)));
        assertThat(ro.getShippingAddress().contains(list.get(6)));
        assertThat(ro.getShippingAddress().contains(list.get(7)));
        assertThat(ro.getShippingAddress().contains(list.get(8)));
        ro.placeOrder();

    }


    @And("^the user checkout with card details and places order$")
    public void checkoutAndEnterCardDetails(DataTable tblValues) throws Exception {
        sbp.clickCheckOut();
        List<String> list = tblValues.asList(String.class);
        sp.clickContinueToBilling();
        bp.enterCVVIfEnabled(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), false, false);
        bp.reviewOrder();
        ro.placeOrder();
    }



    @Then("^Order summary has the Total Due today calculated correctly$")
    public void verifyOrderSummaryTotalDue() {
        double expectedTotalOrderDue;
        DecimalFormat df = new DecimalFormat("0.00");
        expectedTotalOrderDue = (Double.parseDouble(ro.getSubTotal()) + Double.parseDouble(ro.getSalesTax()) - Double.parseDouble(ro.getOrderDiscounts())) / 5;
        expectedTotalOrderDue += Double.parseDouble(ro.getStdDelivery());
        assertThat(df.format(expectedTotalOrderDue)).isEqualTo(ro.getTotalDueToday());

    }


    @Then("^Stretch Pay order should not go through successfully$")
    public void stretchPayShouldNotGoThrough(){
        assertThat(ro.getErrorMsg().contains("There is a problem with StretchPay™ on your account. Please contact Customer Service at (800) 550-8393")).isTrue();
    }

}
