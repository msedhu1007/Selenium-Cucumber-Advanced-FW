package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BaseClass;

public class QuickBuy extends BasePage{
	
	BaseClass bc = new BaseClass();
	By txtFirstName = By.id("qb-first");
	By txtLastName = By.id("qb-last");
	By txtAddressOne = By.id("qb-address-1");
	By txtAddressTwo = By.id("qb-address-2");
	By txtCity = By.id("qb-city");
	By listCountry = By.id("qb-country");
	By listState = By.id("qb-state");
	By txtZip = By.id("qb-zip-shipping");
	
	By chkboxMakeDefault = By.cssSelector("label[for='shipping']");
	By btnSaveFutureOrders = By.id("submit-address-form");
	
	
	//By IconPlusSignAddNewPayment = By.className("icon icon-plus");bc.webelement(IconPlusSignAddNewPayment)
	By linkAddNewPayment = By.id("payment-title");
	By QuickSetupHeading = By.cssSelector("div.account-heading h1");
	By txtQuickSetupBuy = By.xpath("(//div[@class='account-heading']/p)[1]");
	By txtQuickSetupBuyy = By.xpath("(//div[@class='account-heading']/p)[2]");
	By modalHeading = By.cssSelector("div.modal-header");
	By rdo_suggestedAddress = By.cssSelector("input#suggested + label");
	By rdo_enteredAddress = By.cssSelector("input#entered + label");
	By btnUseThisAddress = By.id("use-avs-address");
	By btnEditQuickPref = By.xpath("//a[contains(text(),'Edit QuickBuy Preferences')]");
	By txtAddress = By.cssSelector("p.address");
	By txtDefaultQBAddress = By.cssSelector("span.icon.icon-truck");
	By lnkEditAddress = By.cssSelector("a.edit-link");
	By btnDeleteAddress = By.xpath("//a[text()='Delete This Address']");
	By btnDelete = By.id("submit");
	By btnCancel = By.xpath("//a[contains(text(),'Cancel')]");
	By btnEditQuickBuyPrefereces = By.cssSelector("div.account-section.edit-quickbuy a");
	
	
	
	public int isQuickBuyElementsDisplayed() {
		if(isAddressPresent()) {
			deleteAddress();
		}
		ArrayList<WebElement> ElementList = new ArrayList<>(Arrays.asList(bc.webelement(txtFirstName),bc.webelement(txtLastName),bc.webelement(txtAddressOne),bc.webelement(txtAddressTwo),bc.webelement(txtCity),bc.webelement(listCountry), bc.webelement(listState),bc.webelement(txtZip), bc.webelement(chkboxMakeDefault),bc.webelement(btnSaveFutureOrders), bc.webelement(linkAddNewPayment),bc.webelement(QuickSetupHeading), bc.webelement(txtQuickSetupBuy)));
		long count = ElementList.stream()
				.filter(item -> item.isDisplayed()).count();
		return (int) count;
	}

	public boolean isQuickBuyPageOpened(){
		return bc.getText(QuickSetupHeading).contains("Setup QuickBuy");	
	}

	public void waitforQuickBuyPagetoOpen() {
		bc.WaitForElementPresent(QuickSetupHeading,10);	
	}
	
	public void AddNewAddress(String firstname, String lastname, String address1, String address2, String city, String country, String state, String zip, String value) {
		if(isAddressPresent()) {
			deleteAddress();
		}
		bc.WaitForElementPresent(txtFirstName, 20);
		bc.SendKeys(txtFirstName, firstname);
		bc.SendKeys(txtLastName, lastname);
		bc.SendKeys(txtAddressOne, address1);
		bc.SendKeys(txtAddressTwo, address2);
		bc.SendKeys(txtCity, city);
		bc.SelectTextByVisibleText(listCountry, country);
		bc.SelectTextByVisibleText(listState, state);
		bc.SendKeys(txtZip, zip);
		if(Boolean.valueOf(value)) {
			bc.selectChkbox(chkboxMakeDefault);
		}
		bc.click(btnSaveFutureOrders);
		bc.WaitForElementPresent(modalHeading,15);
		bc.click(rdo_suggestedAddress);
		bc.click(btnUseThisAddress);
		bc.WaitForElementPresent(btnEditQuickPref,30);
	}
	
	public String getAddress() {
		return bc.getText(txtAddress);
	}
	
	public Boolean isAddressPresent() {
		if(bc.getCount(txtAddress)>0) {
			return true;
		}
		return false;
	}
	
	public void deleteAddress() {
		bc.waitUntillElementToBeVisible(lnkEditAddress,10);
		bc.click(lnkEditAddress);
		bc.waitUntillElementToBeVisible(btnDeleteAddress,10);
		bc.click(btnDeleteAddress);
		bc.WaitForElementPresent(btnDelete,10);
		bc.click(btnDelete);
		bc.WaitForElementPresent(btnEditQuickBuyPrefereces, 10);
		bc.click(btnEditQuickBuyPrefereces);
	}
	
	


}
