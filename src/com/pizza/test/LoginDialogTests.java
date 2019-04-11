package com.pizza.test;
import org.junit.Assert;
import org.junit.Test;

import com.pizza.dialog.LoginDialog;
import com.pizza.dialog.LogoutDialog;
import com.pizza.pages.HomePage;
import com.pizza.pages.ProfilePage;


public class LoginDialogTests extends BaseTestSuite {
	
	
	@Test
	public void LoginFieldValidationErrorMessage() {
		HomePage homepage = new HomePage(driver);
		LoginDialog logindialog = homepage.clickLoginLink();
		logindialog.ClickLogin();
		Assert.assertEquals("Alert Message did not display correctly","Your login was unsuccessful - please try again",logindialog.GetAlertMessage());
		logindialog.ClickDismissIcon();
		Assert.assertEquals("Alert Message did not clear correctly","",logindialog.GetAlertMessage());
		
	}
	
	@Test
	public void LoginProfileValidation() {
		HomePage homepage = new HomePage(driver);
		String homeURL = homepage.getCurrentURL();
		LoginDialog logindialog = homepage.clickLoginLink();
		String username = "bob";
		logindialog.setUserName(username);
		logindialog.setPassowrd("ilovepizza");
		logindialog.ClickLogin();
		ProfilePage profile = homepage.clickProfileLink();
	    
	    // Verify the header text 
	  // Assert.assertEquals("Welcome message did not correctly displayed", username,profile.getWelcomeMessage());
		    
	    String profileUrl = profile.getProfileUrl();
	    LogoutDialog logout = profile.clickLogoutLink();
	    logout.clickYesButton();
	    
	    // Attempt to navigate to the captured Profile page URL
	    HomePage.NaivgatetoUrl(profileUrl);
	    
	    // Verify that you are redirected to the home page
	  	Assert.assertEquals("Page should not have navigated away from Home",homeURL, homepage.getCurrentURL());
	  	    
	 
	}
	
	
	

}
