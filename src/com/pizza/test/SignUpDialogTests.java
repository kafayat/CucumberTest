package com.pizza.test;
import org.junit.Assert;
import org.junit.Test;

import com.pizza.dialog.LoginDialog;
import com.pizza.dialog.SignUpDialog;
import com.pizza.pages.HomePage;

import utils.Utilites;


public class SignUpDialogTests extends BaseTestSuite {
	
	
	@Test
	public void SignUpFieldValidationErrorMessage() {
		
		HomePage homepage = new HomePage(driver);
		LoginDialog logindialog = homepage.clickLoginLink();
		
		// Click Login/SignUp navigation menu
		SignUpDialog signupDialog = logindialog.clickSignUpLink();
		
		// Click SignUp Button
		signupDialog.clickSignUpButton();
		
		// Verify the error message
		Assert.assertEquals("Username required did not display correctly","Username is required", signupDialog.getUserNameError());
		Assert.assertEquals("Password required did not display correctly","Password is required", signupDialog.getpasswordError());
		Assert.assertEquals("Confirm Password did not display correctly","Please confirm your password", signupDialog.getConfirmpasswordError());
	
		// Enter Invalid format
		signupDialog.setUserNameField("abc");
		signupDialog.setPasswordField("abc");
		signupDialog.setConfirmPasswordField("def");
		
		Assert.assertEquals("Invalid Username did not display correctly","Username must be minimum of 6 characters", signupDialog.getUserNameError());
		Assert.assertEquals("Invalid password did not display correctly","Password must be minimum of 8 characters", signupDialog.getpasswordError());
		Assert.assertEquals("Password confirmation error did not display correctly","Your passwords do not match", signupDialog.getConfirmpasswordError());
		
		signupDialog.clearUsernameField();
		signupDialog.setUserNameField("donaldtrump");
		// verify username already exist message
		Assert.assertEquals("Username already error did not display correctly","Username already exists", signupDialog.getUserNameError());
		
		 String chars = "0123456789";
		 String username = "robinhood"+ Utilites.randomString(chars, 3);
		 
		// Enter valid credentials into the text field
		 signupDialog.clearUsernameField();
		 signupDialog.setUserNameField(username);
		 signupDialog.clearPasswordField();
		 signupDialog.setPasswordField("letmein2019");
		 signupDialog.clearConfirmPasswordField();
		 signupDialog.setConfirmPasswordField("letmein2019");
		 
		// verify that no error messages are displayed
		Assert.assertEquals("Username error did not clear correctly","", signupDialog.getUserNameError());
		Assert.assertEquals("Password error did not clear correctly","", signupDialog.getpasswordError());
		Assert.assertEquals("Password confirmation error did not clear correctly","", signupDialog.getConfirmpasswordError());
	
		signupDialog.clickSignUpButton();
		Assert.assertEquals("Account creation popup message did not display", "Thanks " + username + ","+ " you can now login.",
					signupDialog.getPopupMessage());
	
			
	}

}
