package com.poc.pages;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.poc.utilities.PropHolder;

public class AddToCart {

	final WebDriver driver;
	public Logger logger = Logger.getLogger("Contact Form");

	PageObjects po;
	// Constructor, as every page needs a Webdriver to find elements
	public AddToCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		 po= new PageObjects(driver);
	}

	
	public void launch_WebSite() {
		driver.get(PropHolder.getUrl());
		logger.info("Amazon Web Application has been loaded.");
	}
	
	
	public void Verify_Title() {
			if(driver.getTitle().contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
				assertTrue(true);
				logger.info("Title Matched - Amazon Web");
			}else {
				logger.info("Title Not Matched");
				assertTrue(false);
			}
	}

	public void selectCateogiry(String val) throws InterruptedException
	{
		Thread.sleep(3000);
		Select dropCateigiry = new Select(po.cateogiryDropDown);
		logger.info("Drop Down Clicked");
		dropCateigiry.selectByVisibleText("Books");
		Thread.sleep(1000);
	}
	public void searchForaItem(String name)
	{
		po.searchTF.sendKeys(name);
		logger.info("Entered the search value "+name);
		po.searchBtn.click();
		logger.info("Search Button clicked");
	}
	
	public void selectTheItem() throws InterruptedException
	{
		Thread.sleep(5000);
		po.selectBook.click();
		logger.info("Book has been Selected");
		Set<String> comWindowHandles=driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		for(String whHandle:comWindowHandles)
		{
			if(!parentWindow.equals(whHandle))
			{
				System.out.println("Window handles");
				driver.switchTo().window(whHandle);
				logger.info("You're in Add Cart Screen");
				Thread.sleep(1000);
				po.buyNow.click();
				Thread.sleep(3000);
			}
		}
	}
	
	public void signIN()
	{
		po.signOnHeader.click();
		logger.info("Sign On header clicked");
		po.userName.sendKeys(PropHolder.getUserName());
		po.continueBtn.click();
		po.password.sendKeys(PropHolder.getPassword());
		logger.info("Credentials Entered.");
	}
}
	
