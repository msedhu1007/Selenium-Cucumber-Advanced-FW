package stepDefinitions;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.BaseClass;
import utilities.Log;

public class Hooks {
	BaseClass bc = new BaseClass();
	
	@After
	public void quit(Scenario scenario) throws IOException, InterruptedException {	
		bc.capturess(scenario);
		bc.tearDown();
		Log.info("Driver is closed");
	}


	@Before
	public void setUp() throws Exception {
		bc.openBrowser();
		bc.maximizeWindow();
		bc.deleteAllCookies();
		bc.setEnv();
		bc.implicitWait(1);	
	}

}
