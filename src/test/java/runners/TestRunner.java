package runners;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.BaseClass;
import utilities.ReportHelper;


@CucumberOptions(  
		plugin = {"pretty","json:target/cucumber.json","html:target/cucumber-html-default","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},  
		strict = true,  
		tags = "@login , @quickbuy, @searchpage, @createAccount, ~@ignore",
		features = {"classpath:features"},  
		glue = {"stepDefinitions"}  
		)  

public class TestRunner  extends AbstractTestNGCucumberTests{
	private static final Logger LOG = Logger.getLogger(TestRunner.class);
	BaseClass bc = new BaseClass();

    /**
     * Passing path for extent reports
     */
 
   
    

	public void tearDown(ITestResult result) throws IOException {
		bc.captureScreenshot(result);
	}



	@AfterSuite(alwaysRun=true)
	public void generateHTMLReports() {
		ReportHelper.generateCucumberReport();
	}








}
