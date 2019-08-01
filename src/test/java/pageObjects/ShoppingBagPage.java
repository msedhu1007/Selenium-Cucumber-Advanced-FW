package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class ShoppingBagPage extends BasePage{
	
    BaseClass bc = new BaseClass();

	
	By lnkContinueShopping = By.id("continue-shopping");
	By txtShoppingBag = By.cssSelector("p.empty-message");
	By headingShoppingBag = By.cssSelector("div.cart-title h1");
	By btnCheckOutNow = By.id("checkout-now");
	
	public Boolean isShoppingBagOpen() {
		return bc.isDisplayed(lnkContinueShopping);
	}
	
	public void waitforPageToOpen() {
		bc.waitUntillElementToBeVisible(lnkContinueShopping, 20);
	}
	
	public void clickContinueShopping() {
		bc.click(lnkContinueShopping);
	}
	
	public List<String> getHeadingAndMessage(){
		List<String> ls = new ArrayList<String>();
		ls.add(bc.getText(headingShoppingBag));
		ls.add(bc.getText(txtShoppingBag));
		return ls;
	}
	
	public Boolean isContinueShoppingLinkDisplayed() {
		return bc.isDisplayed(lnkContinueShopping);
	}
	
	public void clickCheckOut() {
		bc.waitUntillElementToBeVisible(btnCheckOutNow, 15);
		bc.click(btnCheckOutNow);
	}
	
	

}
