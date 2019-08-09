package stepDefinitions;

import cucumber.api.java.en.And;
import pageObjects.AccountHomePage;
import pageObjects.AddressManagerPage;
import pageObjects.HomePage;
import pageObjects.ShippingPage;

public class AccountHomeSteps {

    AddressManagerPage amp = new AddressManagerPage();
    AccountHomePage ahp = new AccountHomePage();
    ShippingPage sp = new ShippingPage();
    HomePage hp = new HomePage();

    String address1 = "PO Box 105576";
    String city = "Atlanta";
    String country = "United States";
    String state = "GA";
    String zipcode = "30348-5576";


    @And("^Add Shipping Address if not exists$")
    public void AddShippingAddressIfNotExists(){
        hp.handleModal();
        System.out.println(ahp.chkShippingAddressIsEmpty());
        if(ahp.chkShippingAddressIsEmpty()){
            ahp.clickShippingAddress();
            amp.clickAddNewAddress();
            amp.addNewAddress("Mike", "Thacker", address1,"",city,country,state,zipcode);
            sp.selectSuggestedAddress();
        }


    }
}
