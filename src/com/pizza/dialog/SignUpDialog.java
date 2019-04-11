package com.pizza.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.pizza.pages.BaseNavigation;

import utils.Utilites;

public class SignUpDialog extends BaseNavigation {
	
	
	By userNameError= By.id("username-err");
	By passwordError= By.id("password-err");
	By confirmPasswordError= By.id("confirm-err");
	By usernameField = By.cssSelector(".v-dialog__content--active input[aria-label='Username']");
	By passwordField = By.cssSelector(".v-dialog__content--active input[aria-label='Password']");
	By confirmPasswordField = By.cssSelector(".v-dialog__content--active input[aria-label='Confirm Password']");
	By popUpMessage = By.cssSelector("div.v-snack--active span.popup-message");
	By signupButton = By.cssSelector("#signupDialog button[aria-label='signup']");
	   

	public SignUpDialog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	
	public String getUserNameError() {
		return Utilites.elementLocatorExists(driver, userNameError, 1, 0) ? 
				driver.findElement(userNameError).getText() : "";}
		
	public String getpasswordError() {
		return Utilites.elementLocatorExists(driver, passwordError, 1, 0) ? 
				driver.findElement(passwordError).getText() : "";}
	
	public String getConfirmpasswordError() {
		return Utilites.elementLocatorExists(driver, confirmPasswordError, 1, 0) ? 
				driver.findElement(confirmPasswordError).getText() : "";}
	
	public void setUserNameField(String username) {
		driver.findElement(usernameField).sendKeys(username);}
	
	public void setPasswordField(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void setConfirmPasswordField(String confirmpassowrd) {
		driver.findElement(confirmPasswordField).sendKeys(confirmpassowrd);
	}
	
	
	public void clearUsernameField() {		
		driver.findElement(usernameField).sendKeys(Keys.CONTROL + "a");
		driver.findElement(usernameField).sendKeys(Keys.DELETE);
	}
	
	public void clearPasswordField() {		
		driver.findElement(passwordField).sendKeys(Keys.CONTROL + "a");
		driver.findElement(passwordField).sendKeys(Keys.DELETE);
	}
	
	public void clearConfirmPasswordField() {		
		driver.findElement(confirmPasswordField).sendKeys(Keys.CONTROL + "a");
		driver.findElement(confirmPasswordField).sendKeys(Keys.DELETE);
	}
	
	public String getPopupMessage() {			
		return Utilites.elementExists(driver, popUpMessage, 3, 0)?
				driver.findElement(popUpMessage).getText(): "";	
	}
	
	public void clickSignUpButton() {
		driver.findElement(signupButton).sendKeys(Keys.ENTER);
	}



	

}
