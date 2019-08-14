package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class OrderResponsePage {
	BaseClass bc = new BaseClass();
	By txtOrderConfirmation = By.cssSelector("p.checkout-title-sub");
	By txtOrderResponse = By.cssSelector("div.checkout-title h1");
	By orderSummary = By.cssSelector("h3.totals-header");
	By txtShippingCost = By.xpath("//span[contains(text(),'Shipping Cost')]/parent::div");

	public String getOrderResponse() {
		bc.waitUntillElementToBeVisible(txtOrderConfirmation, 25);
		return bc.getText(txtOrderConfirmation);
	}


	public String getOrderSuccessConfirmation() {
		bc.waitUntillElementToBeVisible(txtOrderConfirmation, 20);
		return bc.getText(txtOrderConfirmation);
	}

	public String getShippingCost(){
		return bc.getText(txtShippingCost);
	}


	public void waitforOrderResponsePageToOpen(){

	}
}
