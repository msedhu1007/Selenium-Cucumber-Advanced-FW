package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.BaseClass;
import utilities.Log;

import java.io.IOException;
import java.util.Collection;


public class Hooks {
    BaseClass bc = new BaseClass();
    public Collection<String> coll;

    @After
    public void quit(Scenario scenario) throws IOException, InterruptedException {
        bc.capturess(scenario);
        bc.tearDown();
        Log.info("Driver is closed");
    }


    @Before
    public void setUp(Scenario scenario) throws Exception {
        bc.openBrowser();
        bc.maximizeWindow();
        bc.deleteAllCookies();
        bc.setEnv();
        bc.implicitWait(0);
    }




}
