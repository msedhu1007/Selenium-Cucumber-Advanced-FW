package stepDefinitions;

import cucumber.api.java.en.And;
import pageObjects.BillingPage;
import pageObjects.PaypalPage;
import utilities.BaseClass;

public class PaypalSteps {

    BaseClass bc = new BaseClass();
    PaypalPage pp = new PaypalPage();
    BillingPage bp = new BillingPage();
    private String email = "sedhu.madhavan@jtv.com";
    private String pwd = "P@ssword";
    private String fName = "John";
    private String lName = "Kennedy";
    private String expDt = "05/22";
    private String cvv = "578";
    private String cardNo = "6011800547481868";


    @And("^User places an Paypal Order$")
    public void userPlacesOrder() throws Exception{
        bp.selectPaypal();
        pp.loginPayPal(email, pwd);
        pp.addPaymentAndContinue(fName, lName,cardNo, expDt, cvv);

    }
}
