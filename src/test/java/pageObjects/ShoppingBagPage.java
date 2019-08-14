package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBagPage extends BasePage {

    BaseClass bc = new BaseClass();


    By lnkContinueShopping = By.id("continue-shopping");
    By headingShoppingBag = By.cssSelector("div.cart-title h1");
    By btnCheckOutNow = By.id("checkout-now");
    By errMessage = By.cssSelector("div.alert-box.error p");
    By btnRemove = By.cssSelector("div.item-actions.non-mobile a.remove-item-from-cart.item-action-link");
    StringBuffer str = new StringBuffer("(//div[@class='item-actions non-mobile']/a[@class='remove-item-from-cart item-action-link'])[");
    By txtEmptyBag = By.cssSelector("p.empty-message");

    public Boolean isShoppingBagOpen() {
        return bc.isDisplayed(lnkContinueShopping);
    }

    public void waitforPageToOpen() {
        bc.waitUntillElementToBeVisible(lnkContinueShopping, 20);
    }

    public void clickContinueShopping() {
        bc.click(lnkContinueShopping);
    }

    public String getHeadingAndMessage() {
        return bc.getText(headingShoppingBag);
    }

    public Boolean isContinueShoppingLinkDisplayed() {
        return bc.isDisplayed(lnkContinueShopping);
    }

    public void clickCheckOut() {
        bc.waitUntillElementToBeVisible(btnCheckOutNow, 25);
        bc.click(btnCheckOutNow);
    }

    public String verifyErrorMessage() {
        return bc.getText(errMessage);
    }


    public void removeItem() {
        List<WebElement> lst = bc.findAllElements(btnRemove);
        if (lst.size() > 0) {
            bc.JSClick(By.xpath(str.append("1]").toString()));
        }
    }

    public int getNoOfItems() {
        return bc.getCount(btnRemove);
    }

    public Boolean isBagEmpty(){
        return bc.getCount(txtEmptyBag) > 0 ? true : false;
    }


}
