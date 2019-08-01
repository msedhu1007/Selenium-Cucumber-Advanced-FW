package pageObjects;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class ReviewOrderPage extends BasePage{

	By btnPlaceOrder = By.id("method-submit");
	By linkEditShoppingBag = By.xpath("//a[contains(text(),'Edit Shopping Bag')]");
	////a[text()='Edit']
	By txtShippingAddress = By.cssSelector("div.account-section.shipping-address ul");
	By lnkEditShippingAddress = By.cssSelector("div.account-section.shipping-address a");
	By lnkEditBillingAddress = By.cssSelector("div.account-section.billing-address a");
	By lnkEditPaymentMethod = By.cssSelector("div.cc-group a");
	By txtBillingAddress = By.cssSelector("div.account-section.billing-address ul");
	By salesPrice = By.cssSelector("div.sales-price");
	By duePrice = By.cssSelector("div.item-price-due-today");
	By orderTotal = By.xpath("(//div[text()='Order Total']/following-sibling::div)[1]");
	BaseClass bc = new BaseClass();

	public void placeOrder() {
		bc.WaitForElementPresent(btnPlaceOrder, 15);
		bc.click(btnPlaceOrder);
	}

	public String getShippingAddress() {
		bc.WaitForElementPresent(txtShippingAddress, 15);
		return bc.getText(txtShippingAddress);
	}
	
	
	public String getBillingAddress() {
		bc.WaitForElementPresent(txtBillingAddress, 15);
		return bc.getText(txtBillingAddress);
	}
	
	public String getTotalOrderAmt() {
		bc.WaitForElementPresent(orderTotal, 15);
		return bc.getText(orderTotal);
	}

}
