package com.poc.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.poc.base.BaseInitialiser;

public class PageObjects extends BaseInitialiser{
	
	final WebDriver driver;
	public Logger logger = Logger.getLogger("Contact Form");

	// Constructor, as every page needs a Webdriver to find elements
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locating the AccessCode text box
	@FindBy(id = "searchDropdownBox")
	WebElement cateogiryDropDown;

	// Locating the username text box
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTF;

	// Locating the username text box
	@FindBy(xpath = "//div[@class='sg-row']//span[@class='rush-component']//img[1]")
	WebElement selectBook;

	// Locating the Sign On button text box
	@FindBy(id = "buy-now-button")
	WebElement buyNow;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	@FindBy(id="ap_email")
	WebElement userName;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	@FindBy(xpath="//span[text()='Hello, Sign in']")
	WebElement signOnHeader;

}
