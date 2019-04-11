package com.pizza.dialog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.pizza.pages.BaseNavigation;

public class LogoutDialog extends BaseNavigation {
	
	By yesButton = By.cssSelector("div.v-dialog--active   button[aria-label='yes']");
	

	public LogoutDialog(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickYesButton() {
		driver.findElement(yesButton).sendKeys(Keys.ENTER);
	}

}
