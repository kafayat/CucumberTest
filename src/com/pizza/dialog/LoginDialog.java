package com.pizza.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.pizza.pages.BaseNavigation;

public class LoginDialog extends BaseNavigation {
	
	By loginButton = By.cssSelector("div.v-dialog--active button[aria-label='login']");
    By alertMessage = By.cssSelector("div.v-dialog--active i + div");
    By dismissIcon = By.cssSelector("div.v-dialog--active a.v-alert__dismissible");
    By userNameField = By.cssSelector("div.v-dialog--active input[id*='username']");
    By passowrdField = By.cssSelector("div.v-dialog--active input[id*='password']");
    By signupLink = By.linkText("Sign Up");
   
	
    public LoginDialog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickLogin() {
		driver.findElement(loginButton).sendKeys(Keys.ENTER);
	}
	
	public String GetAlertMessage() {
		
		return driver.findElement(alertMessage).getText();
		
	} 
	
	public void ClickDismissIcon() {
		driver.findElement(dismissIcon).click();
	}
	
	public void setUserName(String username) {
		driver.findElement(userNameField).sendKeys(username);
	}
	
	public void setPassowrd(String password) {
		driver.findElement(passowrdField).sendKeys(password);
	}
	
	//public void clickSignUpLink() {
	//	driver.findElement(signupLink).click();
	//}
	
	
	
	public SignUpDialog clickSignUpLink() {
		driver.findElement(signupLink).click();
		return new SignUpDialog(driver);
	}

}
