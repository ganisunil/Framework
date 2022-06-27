package com.poc.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver;
	public static Logger logger=Logger.getLogger(BrowserFactory.class);

	public static WebDriver createWebDriver(String browserName) {
		try {
			BrowserFactory.destroyDriver();
			Thread.sleep(5);
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			openBrowserNew(browserName);
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	public static void destroyDriver() {
		if(driver != null) {
			driver.quit();
			driver=null;
		}
		System.gc();
	}

	public static void openBrowserNew(String browserType) {
		switch(browserType.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		default:
			logger.info("Invalid Browser Details");
			break;
		}
	}

}
