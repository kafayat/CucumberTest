package com.pizza.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizza.test.BaseTestSuite;

import utils.Utilites;



public class ContactPage  extends BaseNavigation{
	
		
	public ContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	By fornameField = By.id("forename");
	By emailField = By.id("email");
	By messageField = By.id("message");
	By phoneField = By.id("telephone");
	By submitButton = By.cssSelector("a[aria-label='submit']");
	By clearButton = By.cssSelector("a[aria-label='clear']");
	By forenameError = By.id("forename-err");
	By emailError = By.id("email-err");
	By messageError = By.id("message-err");
	By phoneError = By.id("telephone-err");
	By successMessage = By.cssSelector("div.success-message div");
	
	public void ClickSubmit() {	
		driver.findElement(submitButton).click();}
	
	
	public void ClearButton() {		
		driver.findElement(clearButton).click();}
	
	// Get Error messages 
	
	public String getFornameError() {
		return Utilites.elementLocatorExists(driver, forenameError, 1, 0) ? 
				driver.findElement(forenameError).getText() : "";
	}
		 
	
	public String getEmailError() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String EmailText = driver.findElements(emailError).size()>0 ?
				driver.findElement(emailError).getText() : "";		
				driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
				return EmailText;
	
	}
	
	public String getMessageError() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String MessageText = driver.findElements(messageError).size()>0 ?
				driver.findElement(messageError).getText() : "";		
				driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
				return MessageText;
	//	return Utilites.elementExists(driver, messageError, 5, 0)?
			//	driver.findElement(messageError).getText(): "";
				}
	
	public String getPhoneError() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String PhoneText = driver.findElements(phoneError).size()>0 ?
				driver.findElement(phoneError).getText() : "";		
				driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
				return PhoneText;
	}
	
	// Set Fields Value
	
	public void setFornameField(String forname) {
		driver.findElement(fornameField).sendKeys(forname);	}
	
	public void setEmailField(String email) {
		driver.findElement(emailField).sendKeys(email);	}
	
	public void setMessageField(String message) {
		driver.findElement(messageField).sendKeys(message);	}
	
	public void setPhoneField(String phone) {
		driver.findElement(phoneField).sendKeys(phone);	}
	
	public String getSuccessMessage() {
		
		
				
		return Utilites.elementLocatorExists(driver, successMessage, 60, 0) ? 
				driver.findElement(successMessage).getText() : "";
	}

}
