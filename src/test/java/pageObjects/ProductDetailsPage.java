package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class ProductDetailsPage extends BasePage{
	
	BaseClass bc = new BaseClass();
	By btnAddToBag = By.id("add-to-cart-submit");
	By btnQuickBuy = By.id("quick-buy-submit");
	By eleRingSize = By.xpath("(//div[@class='size-tile '])[1]");
	By chkboxStretchPay = By.xpath("//label[@for='stretch-pay']");
	By eleFilter = By.cssSelector("div.applied-facet-item");
	
	public void addToBag() {
		bc.WaitForElementPresent(btnAddToBag, 15);
		bc.JSClick(btnAddToBag);
	}
	
	public void clickBag() {
		bc.WaitForElementPresent(iconBag, 15);
		bc.JSClick(iconBag);
	}
	
	public void selectAnySize() {
		if(bc.findAllElements(eleRingSize).size()>0){
			bc.JSClick(eleRingSize);
		}

	}

	public void selectStretchPay(){
		bc.click(chkboxStretchPay);
	}
	
	
	

}
