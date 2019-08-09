package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class OrderResponsePage {
	BaseClass bc = new BaseClass();
	By txtOrderConfirmation = By.cssSelector("p.checkout-title-sub");
	By txtOrderResponse = By.cssSelector("div.checkout-title h1");
	By orderSummary = By.cssSelector("h3.totals-header");

	public String getOrderResponse() {
		bc.waitUntillElementToBeVisible(txtOrderConfirmation, 15);
		return bc.getText(txtOrderConfirmation);
	}


	public String getOrderSuccessConfirmation() {
		bc.waitUntillElementToBeVisible(txtOrderConfirmation, 15);
		return bc.getText(txtOrderConfirmation);
	}
}
