package stepDefinitions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import cucumber.api.java.en.And;
import io.cucumber.datatable.DataTable;
import pageObjects.ReviewOrderPage;
import utilities.BaseClass;


public class ReviewOrderSteps {
	ReviewOrderPage ro = new ReviewOrderPage();
	
			
	@And("^the user reviews and places the Order$")
	public void reviewAndPlaceOrder(DataTable tblvalues)  {
		
		List<String> list = tblvalues.asList();
		System.out.print(ro.getShippingAddress());
		System.out.print(ro.getShippingAddress());
		
		assertThat(ro.getShippingAddress().contains(list.get(0)));
		assertThat(ro.getShippingAddress().contains(list.get(1)));
		assertThat(ro.getShippingAddress().contains(list.get(2)));
		assertThat(ro.getShippingAddress().contains(list.get(3)));
		assertThat(ro.getShippingAddress().contains(list.get(4)));
		assertThat(ro.getShippingAddress().contains(list.get(5)));
		assertThat(ro.getShippingAddress().contains(list.get(6)));
		assertThat(ro.getShippingAddress().contains(list.get(7)));
		assertThat(ro.getShippingAddress().contains(list.get(8)));
		ro.placeOrder();
		
//		assertThat(ro.getShippingAddress().contains(data.get(1).get("First Name").toLowerCase()));
//		assertThat(ro.getShippingAddress().contains(data.get(0).get("Last Name").toLowerCase()));
//		assertThat(ro.getShippingAddress().contains(data.get(0).get("Phone").toLowerCase()));
//		assertThat(ro.getShippingAddress().contains(data.get(0).get("City").toLowerCase()));
//		assertThat(ro.getShippingAddress().contains(data.get(0).get("Zip Code").toLowerCase()));
//		assertThat(ro.getShippingAddress().contains(data.get(0).get("Address1").toLowerCase()));
//		ro.placeOrder();
	}

}
