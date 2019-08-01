package stepDefinitions;

import cucumber.api.java.en.Then;
import pageObjects.OrderResponsePage;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderReponseSteps {
	
	OrderResponsePage orp = new OrderResponsePage();
	
	@Then("^the order is successfully placed$")
	public void order_successfully_placed() {
		assertThat(orp.getOrderSuccessConfirmation()).as("Verify Order Response").contains("You will receive an email confirmation soon at");
	}

}
