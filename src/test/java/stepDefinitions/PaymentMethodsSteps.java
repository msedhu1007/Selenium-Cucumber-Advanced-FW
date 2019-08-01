package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java8.En;
import pageObjects.PaymentMethodsPage;

public class PaymentMethodsSteps implements En{
	
	PaymentMethodsPage pmp = new PaymentMethodsPage();
	
	//Lambda-steps inside Constructors
		public PaymentMethodsSteps() {
		
			When("the user navigates to Payment Methods page", () -> {
			    pmp.navigateToPaymentDetailsPg();
			});
			
			
			
			Then("user should be presented with Payment Details page", () -> {
			      assertThat(pmp.isAllFieldsDisplayed()).isTrue();

			});
		}

}
