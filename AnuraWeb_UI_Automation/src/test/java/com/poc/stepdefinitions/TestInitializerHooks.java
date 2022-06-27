package com.poc.stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.poc.base.BaseInitialiser;
import com.poc.base.BrowserFactory;
import com.poc.utilities.PropHolder;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestInitializerHooks extends BaseInitialiser{
	public static Scenario sc;
	public static Logger logger=Logger.getLogger(TestInitializerHooks.class);
	
	@Before
	public void beforeScenario(Scenario scenario) {
		String browserName = PropHolder.getBrowserName();
		driver = BrowserFactory.createWebDriver(browserName);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sc = scenario;
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "-");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		driver.close();
		logger.info("Browser is closed");
	}
	
	public static void takeScreenshot() {
		String screenshotName = sc.getName().replaceAll(" ", "-");
		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(sourcePath, "image/png", screenshotName); 
	}

}
