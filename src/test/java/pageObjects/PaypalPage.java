package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class PaypalPage {

    By txtEmail = By.id("email");
    By txtpassword = By.id("password");
    By chkboxStayLoggedIn = By.id("keepMeLoggedIn");
    By btnLogIn = By.id("btnLogin");
    By btnPaywithDebitCredit = By.id("createAccount");
    By btnContinue = By.id("confirmButtonTop");
    By chkboxMakeThisShippingAdd = By.id("makePreferred");
    By linkChange = By.cssSelector("a[aria-label='Change shipping address']");
    By linkManagePayment = By.cssSelector("a.edits.changePayment");
    By linkAddDebitOrCredit = By.cssSelector("p.addOption span");
    By eleExistingCard = By.cssSelector("div.method.PAYMENT_CARD.INSTANT_TRANSFER");
    By txtFirstName = By.id("firstName");
    By txtLastName = By.id("lastName");
    By txtCardNo = By.id("cc");
    By txtExpiryDate = By.id("expiry_value");
    By txtCVV = By.id("cvv");
    By txtBillingAddress = By.id("billingAddressDropdown");
    By btnAdd = By.id("proceedButton");

    BaseClass bc = new BaseClass();

    public void loginPayPal(String username, String password){
        bc.SendKeys(txtEmail, username);
        bc.SendKeys(txtpassword, password);
        bc.click(btnLogIn);
    }


    public void addPaymentAndContinue(String fName, String lName, String expdate, String cardNo, String cvv){
        if(bc.getCount(eleExistingCard) == 0){
            bc.WaitForElementPresent(linkAddDebitOrCredit, 10);
            bc.click(linkAddDebitOrCredit);
            bc.WaitForElementPresent(txtFirstName, 15);
            bc.SendKeys(txtFirstName, fName);
            bc.SendKeys(txtLastName, lName);
            bc.SendKeys(txtCardNo, cardNo);
            bc.SendKeys(txtExpiryDate, expdate);
            bc.SendKeys(txtCVV, cvv);
            bc.click(btnAdd);
        }
        bc.click(btnContinue);
    }


}
