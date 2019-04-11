package com.pizza.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pizza.test.BaseTestSuite;

import utils.Utilites;

public class ProfilePage extends BaseNavigation {
	
	By welcomeMessage = By.tagName("h2");
	By userName = By.cssSelector("h2 em");


	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getWelcomeMessage() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String welcomeText = driver.findElements(welcomeMessage).size()>0 ?
				driver.findElement(welcomeMessage).getText().replace("person ", "") : "";		
				driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
				return welcomeText;
				//return Utilites.elementExists(driver, userName, 1, 0) ? 
				//driver.findElement(welcomeMessage).getText().replace("person ", "") : "";
	
	}
	
		
	public String getProfileUrl() {
		return driver.getCurrentUrl();
	}
	
	

}
