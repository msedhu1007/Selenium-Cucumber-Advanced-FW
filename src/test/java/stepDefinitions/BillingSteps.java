package stepDefinitions;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import pageObjects.BillingPage;
import pageObjects.ReviewOrderPage;
import utilities.BaseClass;

public class BillingSteps implements En{

	BillingPage bp = new BillingPage();
	BaseClass bc = new BaseClass();
	ReviewOrderPage rop = new ReviewOrderPage();

	//Lambda-steps inside Constructors
	public BillingSteps() {
	Then("user is taken to Secure Checkout page", () -> {
			rop.getShippingAddress();
			rop.getBillingAddress();
			rop.getTotalOrderAmt();
		});
		
		
		Then("quickbuy order should be placed successfully", () -> {
		rop.placeOrder();
		});
	}

	@And("^the user enters payment information and email$")
	public void userFillsCardInfo(DataTable tblvalues) throws Exception{
		List<String> list = tblvalues.asList();
		bp.fillCardInfo(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
		bp.selectSameAsShippingAddressFillEmail(list.get(5));
		bp.reviewOrder();

	}

}
