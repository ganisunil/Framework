package com.poc.testrunner;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.poc.utilities.AppConstants;
import com.poc.utilities.PropHolder;
import com.poc.utilities.PropertiesReader;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@Test
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.poc.stepdefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class BaseRunner extends AbstractTestNGCucumberTests{
	
	private Properties configProperties;
	PropertiesReader propFileReader;
	
	@BeforeTest
	public void setEnvDetails() throws IOException {
		String dir = System.getProperty("user.dir")+"\\Reports";
		propFileReader = PropertiesReader.getInstance();
		configProperties = propFileReader.getPropFile(AppConstants.CONFIG_FILEPATH);
		File file = new File(dir);
		for(File f: file.listFiles()) {
			if(f.getName().endsWith(".png")) {
				f.delete();
			}
		}
		PropertyConfigurator.configure("src//test//resources//log4j.properties");
		String browserName = System.getProperty("BrowserName");
		String url = System.getProperty("Url");
		String userName = System.getProperty("UserName");
		String password = System.getProperty("Password");
	
		if (browserName != null) {
			PropHolder.setBrowserName(browserName);
		}else {
			PropHolder.setBrowserName(configProperties.getProperty("BrowserName"));
		}
		
		if (url != null) {
			PropHolder.setUrl(url);
		}else {
			PropHolder.setUrl(configProperties.getProperty("Url"));
		}
		
		if (userName != null) {
			PropHolder.setUserName(userName);
		}else {
			PropHolder.setUserName(configProperties.getProperty("UserName"));
		}
		
		if (password != null) {
			PropHolder.setPassword(password);
		}else {
			PropHolder.setPassword(configProperties.getProperty("Password"));
		}
	}
}
