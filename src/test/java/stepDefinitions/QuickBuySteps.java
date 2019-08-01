package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java8.En;
import io.cucumber.datatable.DataTable;
import pageObjects.AccountHomePage;
import pageObjects.ProductListPage;
import pageObjects.QuickBuy;

public class QuickBuySteps implements En{

	AccountHomePage ahp = new AccountHomePage();
	QuickBuy quickbuy = new QuickBuy();
	ProductListPage plp = new ProductListPage();

	//Lambda-steps inside Constructors
	public QuickBuySteps() {
		
		When("^user places quickbuy order$", () -> {
			plp.selectQuickView();
			plp.clickQuickBuy();
		});
		
	}



		@And("^the user navigates to the Quick Buy page$")
		public void i_navigate_to_the_QuickBuy_page() throws Throwable {
			ahp.navigateToQuickBuyPage();
			ahp.handleEmailModal();
		}


		@Given("^the user is presented with QuickBuy$")
		public void user_Presented_QuickBuypage() throws Throwable {
			assertThat(quickbuy.isQuickBuyElementsDisplayed()).isEqualTo(13);
		}

		@And("^the user adds new address and save$")
		public void user_addSave_newaddresses(Map<String, String> addressinfo) throws Throwable{
			quickbuy.AddNewAddress(addressinfo.get("First Name"), addressinfo.get("Last Name"), addressinfo.get("Address One"), addressinfo.get("Address Two"), addressinfo.get("City"), addressinfo.get("Country"), addressinfo.get("State"), addressinfo.get("Zip code"), addressinfo.get("Default Address"));
		}

		@Then("^the Address should get saved$")
		public void address_should_get_saved(DataTable tableData) throws Throwable{
			List<String> data = tableData.asList();
			String val = quickbuy.getAddress();
			assertThat(val).contains(data.get(0).toUpperCase());
			assertThat(val).contains(data.get(1).toUpperCase());
			assertThat(val).contains(data.get(2).toUpperCase());
			assertThat(val).contains(data.get(4).toUpperCase());
			assertThat(val).contains(data.get(7));
		}



	}
