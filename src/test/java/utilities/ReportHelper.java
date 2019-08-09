package utilities;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHelper {

	
	  public static void generateCucumberReport() {
	        File reportOutputDirectory = new File("target");
	        ArrayList<String> jsonFiles = new ArrayList<String>();
	        jsonFiles.add("target/cucumber.json");

	        String projectName = "testng-cucumber";

	        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	        configuration.addClassifications("Platform", System.getProperty("os.name"));
	        configuration.addClassifications("Browser", "Chrome");

	        // optionally add metadata presented on main page via properties file
	        List<String> classificationFiles = new ArrayList<String>();
	        classificationFiles.add("src/test/resources/config/config.properties");
	        configuration.addClassificationFiles(classificationFiles);

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }
	  
}
