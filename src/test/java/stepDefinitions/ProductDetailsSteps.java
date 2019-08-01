package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import pageObjects.*;

import java.util.List;

public class ProductDetailsSteps {
	ProductDetailsPage pdp = new ProductDetailsPage();
	ShoppingBagPage sbp = new ShoppingBagPage();
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	AccountHomePage ahp = new AccountHomePage();
	ProductListPage plp = new ProductListPage();
	ShippingPage sp = new ShippingPage();
	
	@And("^the user navigates to Bag screen and places Guest checkout$")
	public void userNavigatesToBag_checkout() {
		pdp.hoverOverBag();
		pdp.clickBag();
		sbp.clickCheckOut();
		lp.doGuestCheckOut();
	}
	
	
	@When("^user selects a product$")
	public void userSelectsProduct(DataTable tblvalues) {
		List<String> lst = tblvalues.asList();
		hp.handleModal();
		ahp.navigateToHomePage();
		hp.selectJewelryTypes(lst.get(0));
		plp.selectWatchType(lst.get(1));

	}


	@And("^the user navigates to Bag screen$")
	public void userNavigatesToBagAndCheckoutOrder(){
		pdp.hoverOverBag();
		pdp.clickBag();
		sbp.clickCheckOut();
	}




}
