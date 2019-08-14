package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseClass;

import java.util.List;

public class AddressManagerPage extends BasePage{

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
    By linkEditAddress = By.xpath("//a[@class='edit-link']");
    By btnDeleteAddress = By.xpath("//a[text()='Delete This Address']");
    By btnDelete = By.id("submit");

    public void addNewAddress(String firstNm, String lastNm, String address1, String address2, String city, String country, String state, String zipcode) {
        bc.waitUntillElementToBeVisible(txtFirstName, 20);
        bc.setText(txtFirstName, firstNm);
        bc.setText(txtLastName, lastNm);
        bc.setText(txtAddress1, address1);
        bc.setText(txtAddress2, address2);
        bc.setText(txtCity, city);
        bc.SelectTextByVisibleText(lstCountry, country);
        bc.SelectTextByValue(lstState, state);
        bc.setText(txtZipcode, zipcode);
        bc.click(btnSaveOrders);
    }

    public void clickAddNewAddress() {
        bc.click(linkAddNewAddress);
    }

    public void deleteAllAddress() throws Exception{
        int n = bc.getCount(linkEditAddress);
        List<WebElement> lst = bc.findAllElements(linkEditAddress);
        if (n > 0) {
            lst.get(0).click();
            bc.click(btnDeleteAddress);
            bc.click(btnDelete);
            bc.waitForElementToDisappear(btnDelete);
            bc.WaitForElementPresent(linkAddNewAddress, 20);
        }
        if(bc.findAllElements(linkEditAddress).size()>0){
            bc.findAllElements(linkEditAddress).get(0).click();
            bc.click(btnDeleteAddress);
            bc.click(btnDelete);
            bc.waitForElementToDisappear(btnDelete);
            bc.WaitForElementPresent(linkAddNewAddress, 20);
        }
        if(bc.findAllElements(linkEditAddress).size()>0){
            bc.findAllElements(linkEditAddress).get(0).click();
            bc.click(btnDeleteAddress);
            bc.click(btnDelete);
            bc.waitForElementToDisappear(btnDelete);
            bc.WaitForElementPresent(linkAddNewAddress, 20);
        }
    }


    public void navigatetoAddressMgr() {
        bc.click(lnkMenuItem);
        bc.WaitForElementPresent(linkAddNewAddress,20);
    }
}
