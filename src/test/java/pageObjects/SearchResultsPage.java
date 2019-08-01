package pageObjects;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class SearchResultsPage extends BasePage{
	
	BaseClass bc = new BaseClass();
	By eleBreadcrumb = By.cssSelector("span.crumb");
	
	
	public String getBreadcrumbTxt() {
		return bc.getText(eleBreadcrumb);
	}
	
	
	public void searchItems(String itemName) {
		bc.SendKeys(txtSearch,itemName);
		bc.pressEnter(txtSearch);
	}
	
	
	public void waitforPageToLoad() {
		
	}
	
	

}
