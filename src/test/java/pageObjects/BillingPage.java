package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class BillingPage {

    By txtName = By.id("name");
    By txtCardNo = By.id("card");
    By lstExpirationMonth = By.id("month");
    By lstExpirationYear = By.id("year");
    By txtCVV = By.id("cvv");
    By chkboxSameShippingAddress = By.id("same-as-shipping");
    By txtEmail = By.id("email-same-as-shipping");
    By btnReviewYourOrder = By.xpath("(//button[contains(text(),'Review Your Order')])[2]");
    By txtFirstName = By.id("first-name");
    By txtLastName = By.id("last-name");
    By txtPhone = By.id("phone");
    By txtEmailAddress = By.id("email");
    By txtAddressOne = By.id("address-1");
    By txtAddressTwo = By.id("address-2");
    By txtCity = By.id("city");
    By lstCountry = By.id("country");
    By lstState = By.id("state");
    By txtZip = By.id("zip");
    By btnReviewYourOrderOne = By.xpath("(//button[contains(text(),'Review Your Order')])[1]");
    By linkPaypal = By.cssSelector("label[for='payment-method-radio-paypal']");
    By btnPaypal = By.cssSelector("div.paypal-button-container.paypal-button-layout-horizontal");
    By btnAddNewCard = By.id("cc-title");
    By chkboxDefaultPayment = By.xpath("//input[@id='default-payment-field']/..");
    By chkboxDefaultQuickBuyMethod = By.xpath("//input[@id='qb-field']/..");
    By txtFirstCVV = By.xpath("//div[@class='cvv-needed ']//input[@class='cvv-input']");
    By subtotal = By.xpath("(//div[text()='Subtotal']/following-sibling::div)[2]");
    By stdDelivery = By.xpath("(//div[text()='Standard Delivery']/following-sibling::div)[2]");
    By salesTax = By.xpath("(//div[text()='Sales Tax']/following-sibling::div)[2]");
    By orderTotal = By.xpath("(//div[text()='Order Total']/following-sibling::div)[2]");
    By orderDiscounts = By.xpath("(//div[text()='Order Discounts']/following-sibling::div)[2]");
    By linkApplyjtvPreferredAccnt = By.id("pa-apply-button-submit");
    By eleJTVPreferredAccnt = By.cssSelector("img[alt='JTV Preferred Logo']+span");

    BaseClass bc = new BaseClass();

    public void selectAddNewCreditDebit() {
        bc.WaitForElementPresent(btnAddNewCard, 25);
        if(bc.webelement(btnAddNewCard).isEnabled()) {
            bc.click(btnAddNewCard);
        }
    }


    public void enterCVVIfEnabled(String name, String cardNo, String expMonth, String expYear, String cvv, Boolean defaultPaymentMethod, Boolean defaultQuickBuyPaymentMethod) throws Exception {
        selectAddNewCreditDebit();
        fillCardInfo(name, cardNo, expMonth, expYear, cvv, defaultPaymentMethod, defaultQuickBuyPaymentMethod);

    }

    public void fillCardInfo(String name, String cardNo, String expMonth, String expYear, String cvv, Boolean defaultPaymentMethod, Boolean defaultQuickBuyPaymentMethod) throws Exception {
        bc.WaitForElementPresent(txtName, 15);
        bc.setText(txtName, name);
        bc.setText(txtCardNo, cardNo);
        bc.setText(txtCVV, cvv);
        selectAddNewCreditDebit();
        bc.click(lstExpirationYear);
        bc.SelectTextByIndex(lstExpirationYear, 3);

        if (defaultPaymentMethod) {
            bc.selectChkbox(chkboxDefaultPayment);
        }
        if (defaultQuickBuyPaymentMethod) {
            bc.selectChkbox(chkboxDefaultQuickBuyMethod);
        }
    }


    public void selectSameAsShippingAddressFillEmail(String email) {
        bc.selectChkbox(chkboxSameShippingAddress);
        bc.SendKeys(txtEmail, email);
    }

    public void reviewOrder() {
        bc.WaitForElementPresent(btnReviewYourOrder, 10);
        bc.click(btnReviewYourOrder);
    }


    public void fillCard(String name, String cardNo, String expMonth, String expYear, String cvv) throws Exception {
        bc.WaitForElementPresent(txtName, 15);
        bc.setText(txtName, name);
        bc.setText(txtCardNo, cardNo);
        bc.setText(txtCVV, cvv);
        bc.SelectTextByVisibleText(lstExpirationYear, expYear);
        bc.SelectTextByVisibleText(lstExpirationMonth, expMonth);
    }


    public void enterBillingAddress(String fName, String lName, String phone, String address1, String address2, String city, String country, String state, String zipcode) throws Exception {
        bc.click(chkboxSameShippingAddress);
        bc.WaitForElementPresent(txtFirstName, 15);
        bc.SendKeys(txtFirstName, fName);
        bc.SendKeys(txtLastName, lName);
        bc.SendKeys(txtPhone, phone);
        bc.SendKeys(txtAddressOne, address1);
        bc.SendKeys(txtAddressTwo, address2);
        bc.SendKeys(txtCity, city);
        bc.SelectTextByVisibleText(lstCountry, country);
        bc.SelectTextByValue(lstState, state);
        bc.SendKeys(txtZip, zipcode);
        bc.sleep(2);
        bc.click(btnReviewYourOrderOne);
    }

    public void selectPaypal() throws Exception {
        bc.click(linkPaypal);
        bc.sleep(5);
        bc.switchToFrame(1);
        bc.waitUntilElementToBeClickable(btnPaypal, 30).click();
        String currentWinHandle = bc.getDriver().getWindowHandle();
        bc.JSClick(btnPaypal);
        bc.waitForNumberOfWindowsToOpen(2);
        bc.switchToSecondWindow(currentWinHandle);
    }


    public String getSubTotal() {
        bc.WaitForElementPresent(subtotal, 15);
        return bc.getText(subtotal).trim().substring(1);
    }

    public String getSalesTax() {
        bc.WaitForElementPresent(salesTax, 15);
        return bc.getText(salesTax).trim().substring(1);
    }


    public String getStdDelivery() {
        bc.WaitForElementPresent(stdDelivery, 15);
        return bc.getText(stdDelivery).trim().substring(1);
    }

    public String getOrderTotal() {
        bc.WaitForElementPresent(orderTotal, 15);
        return bc.getText(orderTotal).trim().substring(1);
    }


    public String getOrderDiscounts() {
        if (bc.findAllElements(orderDiscounts).size() > 0) {
            return bc.getText(orderDiscounts).trim().substring(1);
        } else {
            return "0";
        }
    }


    public Boolean isJTVPreferredAccountDisplayed() throws Exception {
        bc.sleep(3);
        if (bc.findAllElements(eleJTVPreferredAccnt).size()>0 || bc.findAllElements(linkApplyjtvPreferredAccnt).size()>0) {
            return true;
        } else {
            return false;
        }
    }


    public void waitForBillingPageToOpen(){
        bc.WaitForElementPresent(btnAddNewCard,20);
    }

}
