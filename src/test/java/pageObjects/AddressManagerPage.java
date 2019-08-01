package pageObjects;

import org.openqa.selenium.By;
import utilities.BaseClass;

public class AddressManagerPage {

    BaseClass bc = new BaseClass();

    By txtFirstName = By.id("first");
    By txtLastName = By.id("last");
    By txtAddress1 = By.id("address-1");
    By txtAddress2 = By.id("address-2");
    By txtCity = By.id("city");
    By lstCountry = By.id("country");
    By lstState = By.id("state");
    By txtZipcode = By.id("zip-shipping");
    By btnSaveOrders = By.id("submit-address-form");
    By linkAddNewAddress = By.id("address-title");

    public void addNewAddress(String firstNm, String lastNm, String address1, String address2, String city, String country, String state, String zipcode){
        bc.waitUntillElementToBeVisible(txtFirstName,20);
        bc.setText(txtFirstName,firstNm);
        bc.setText(txtLastName, lastNm);
        bc.setText(txtAddress1,address1 );
        bc.setText(txtAddress2, address2);
        bc.setText(txtCity,city);
        bc.SelectTextByVisibleText(lstCountry, country);
        bc.SelectTextByValue(lstState,state);
        bc.setText(txtZipcode,zipcode);
        bc.click(btnSaveOrders);
    }

    public void clickAddNewAddress(){
        bc.click(linkAddNewAddress);
    }
}
