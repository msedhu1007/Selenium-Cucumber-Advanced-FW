package pageObjects;

import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.openqa.selenium.By;
import utilities.BaseClass;

public class ReviewOrderPage extends BasePage {

    By btnPlaceOrder = By.id("method-submit");
    By linkEditShoppingBag = By.xpath("//a[contains(text(),'Edit Shopping Bag')]");
    By txtShippingAddress = By.cssSelector("div.account-section.shipping-address ul");
    By lnkEditShippingAddress = By.cssSelector("div.account-section.shipping-address a");
    By lnkEditBillingAddress = By.cssSelector("div.account-section.billing-address a");
    By lnkEditPaymentMethod = By.cssSelector("div.cc-group a");
    By txtBillingAddress = By.cssSelector("div.account-section.billing-address ul");
    By salesPrice = By.cssSelector("div.sales-price");
    By duePrice = By.cssSelector("div.item-price-due-today");
    By orderTotal = By.xpath("(//div[text()='Order Total']/following-sibling::div)[1]");
    By TotalDueToday = By.xpath("//div[text()='Total Due Today*']/following-sibling::div");
    By subtotal = By.xpath("//div[text()='Subtotal']/following-sibling::div");
    By StdDelivery = By.xpath("//div[text()='Standard Delivery']/following-sibling::div");
    By SalesTax = By.xpath("//div[text()='Sales Tax']/following-sibling::div");
    By OrderTotal = By.xpath("(//div[text()='Order Total']/following-sibling::div)[1]");
    By orderDiscounts = By.xpath("(//div[text()='Order Discounts']/following-sibling::div)[2]");

    BaseClass bc = new BaseClass();

    public void placeOrder() {
        bc.WaitForElementPresent(btnPlaceOrder, 15);
        bc.click(btnPlaceOrder);
    }


    public void clickEditShippingAddress(){
        bc.click(lnkEditShippingAddress);
    }

    public String getShippingAddress() {
        bc.WaitForElementPresent(txtShippingAddress, 15);
        return bc.getText(txtShippingAddress);
    }


    public String getBillingAddress() {
        bc.WaitForElementPresent(txtBillingAddress, 15);
        return bc.getText(txtBillingAddress).trim();
    }


    public String getSubTotal() {
        bc.WaitForElementPresent(subtotal, 15);
        return bc.getText(subtotal).trim().substring(1);
    }

    public String getSalesTax() {
        bc.WaitForElementPresent(SalesTax, 15);
        return bc.getText(SalesTax).trim().substring(1);
    }


    public String getStdDelivery() {
        bc.WaitForElementPresent(StdDelivery, 15);
        return bc.getText(StdDelivery).trim().substring(1);
    }


    public String getTotalDueToday() {
        bc.waitUntillElementToBeVisible(TotalDueToday, 10);
        return bc.getText(TotalDueToday).trim().substring(1);
    }


    public String getOrderTotal() {
        bc.WaitForElementPresent(orderTotal, 15);
        return bc.getText(OrderTotal).trim().substring(1);
    }

    public String getOrderDiscounts() {
        if(bc.findAllElements(orderDiscounts).size()>0){
            return bc.getText(orderDiscounts).trim().substring(1);
        }
        else{
            return "0";
        }
    }
}
