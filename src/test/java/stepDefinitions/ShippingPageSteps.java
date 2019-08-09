package stepDefinitions;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import pageObjects.ShippingPage;
import static org.assertj.core.api.Assertions.assertThat;


public class ShippingPageSteps {
	
	ShippingPage sp = new ShippingPage();
	
	@And("^the user enters the Shipping address and continues to Billing$")
	public void enterShippingAddress_Billing(DataTable tblValues) {
		List<String> list = tblValues.asList(String.class);
		sp.enterShippingAddress(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
		sp.selectSuggestedAddress();
	}


	@Then("^the order is not successfully placed with the message Authorization Declined$")
	public void authorizationDeclinedWithMessage(){
		assertThat(sp.getErrorMsg()).startsWith("The credit card").contains("could not be authorized for payment: .").doesNotContain("You will receive an email confirmation soon at");

	}


}
