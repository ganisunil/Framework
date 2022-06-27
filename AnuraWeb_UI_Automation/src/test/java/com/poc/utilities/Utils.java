package com.poc.utilities;

import org.openqa.selenium.By;

import com.poc.base.BaseInitialiser;

public class Utils extends BaseInitialiser{
	
	public  boolean isVisible(By locator) {
    	if(driver.findElements(locator).size() != 0)
        return (driver.findElement(locator).isDisplayed());
    	else
    	return false;
    }

}
