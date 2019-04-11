package com.pizza.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizza.dialog.LoginDialog;
import com.pizza.dialog.LogoutDialog;

import utils.Utilites;



public class BaseNavigation {
	
	protected static WebDriver driver;
	
	By homeLink = By.className("nav-home");
    By menuLink = By.className("nav-menu");
	By contactLink = By.className("nav-contact");
	By userLink = By.className("nav-login-signup");
	By profileLink = By.className("nav-profile");
	By logoutLink = By.linkText("Logout"); 
	By orderLink = By.className("nav-order");
	By orderCount = By.className("order-count");
	
		public BaseNavigation(WebDriver driver) {
	     
		BaseNavigation.driver = driver;
	
		}
	
   		public ContactPage clickContactLink()  {
   			driver.findElement(contactLink).click();
   			return new ContactPage(driver);} 
   		
   		public LoginDialog clickLoginLink() {
   			driver.findElement(userLink).click();
   			return new LoginDialog(driver);	}
   		
   		public ProfilePage clickProfileLink() {
   			driver.findElement(profileLink).click();
   			return new ProfilePage(driver);	}
   		
   		public LogoutDialog clickLogoutLink() {
   			Utilites.moveToElement(driver, profileLink);
   			driver.findElement(logoutLink).click();
   			return new LogoutDialog(driver);
   		} 
   		
   		public String getCurrentURL() {
   			return driver.getCurrentUrl();
   		}
   		
   		public OrderPage clickOrderLink() {
   			driver.findElement(orderLink).click();
			return new OrderPage(driver);
   		}
   		
   		public MenuItemPage clickMenuLink() {
   			driver.findElement(menuLink).click();
			return new MenuItemPage(driver);
   		}
   		
   		public String getOrderCount() {
   			return driver.findElement(orderCount).getText();
   		}
   		
   		
	

}
