package stepDefinitions;

import java.util.List;

import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import pageObjects.ShippingPage;

public class ShippingPageSteps {
	
	ShippingPage sp = new ShippingPage();
	
	@And("^the user enters the Shipping address and continues to Billing$")
	public void enterShippingAddress_Billing(DataTable tblValues) {
		List<String> list = tblValues.asList(String.class);
		sp.enterShippingAddress(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
		sp.selectSuggestedAddress();
	}

	
}
