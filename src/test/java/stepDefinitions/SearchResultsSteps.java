package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pageObjects.AccountHomePage;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import utilities.BaseClass;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps {
	AccountHomePage ahp = new AccountHomePage();
	BaseClass bc = new BaseClass();
	HomePage hp = new HomePage();
	SearchResultsPage searchPage = new SearchResultsPage();
	
	@Then("^Breadcrumb should display \"([^\"]*)\"$")
	public void verify_Breadcrumb(String value) {
		ahp.waitforPageToUnload();
		assertThat(value.equalsIgnoreCase(searchPage.getBreadcrumbTxt().substring(0, 23)));
	}
	
	@And("^the user Search with the text \"([^\"]*)\"$")
	public void userSearchItems(String itemName) {
		hp.handleModal();
		searchPage.searchItems(itemName);
	}
}
