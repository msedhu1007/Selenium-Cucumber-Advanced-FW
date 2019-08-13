package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class ProductDetailsPage extends BasePage{
	
	BaseClass bc = new BaseClass();
	public By btnAddToBag = By.id("add-to-cart-submit");
	By btnQuickBuy = By.id("quick-buy-submit");
	By eleRingSize = By.xpath("(//div[@class='size-tile '])[1]");
	By chkboxStretchPay = By.xpath("//label[@for='stretch-pay']");
	By eleFilter = By.cssSelector("div.applied-facet-item");
	By productSizeGroup = By.cssSelector("div#product-size-group");
	By productQuantityGroup = By.cssSelector("div.quantity-group");

	
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
	
	
	public Boolean isAddToBagDisplayed(){
		return bc.findAllElements(btnAddToBag).size()>0 ? true : false;
	}

	public Boolean isQuickBuyDisplayed(){
		return bc.findAllElements(btnQuickBuy).size()>0 ? true : false;
	}

	public Boolean isSizesDisplayed(){
		return bc.findAllElements(productSizeGroup).size()>0 ? true : false;
	}

	public Boolean isQuantityDisplayed(){
		return bc.findAllElements(productQuantityGroup).size()>0 ? true : false;
	}
}


