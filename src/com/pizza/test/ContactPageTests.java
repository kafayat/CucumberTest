package com.pizza.test;

import org.junit.Assert;
import org.junit.Test;

import com.pizza.pages.ContactPage;
import com.pizza.pages.HomePage;

public class ContactPageTests extends BaseTestSuite {
	
	
	@Test
	public void MandatoryErrorDisplay()  {
		
		HomePage homepage = new HomePage(driver);
		ContactPage contactpage = homepage.clickContactLink();
		contactpage.ClickSubmit();
		
		
		Assert.assertEquals("forename  error did not display correctly", "Forename is required",	contactpage.getFornameError());
		Assert.assertEquals("Email  error did not display correctly", "Email is required", contactpage.getEmailError());
		Assert.assertEquals("Message  error did not display correctly", "Message is required", contactpage.getMessageError());
			
	}
	
	
	@Test
	public void FieldValidationErrorMessages()  {
		
		HomePage homepage = new HomePage(driver);
		ContactPage contactpage = homepage.clickContactLink();
		
		contactpage.setEmailField("xxx");
		contactpage.setPhoneField("xxxx");
		contactpage.setMessageField("");
		contactpage.ClickSubmit();
		
		Assert.assertEquals("Email format error did not display correctly","Email is invalid", contactpage.getEmailError()); 
		Assert.assertEquals("Telephone format error did not display correctly","Telephone is invalid", contactpage.getPhoneError()); 
		Assert.assertEquals("Message error did not display correctly","Message is required", contactpage.getMessageError()); 
		
		contactpage.ClearButton();
		Assert.assertEquals("Email format error did not clear","",contactpage.getEmailError());
		Assert.assertEquals("Telephone format error did not clear","",contactpage.getPhoneError());
	}
	
	@Test
	public void ValidTextFieldSubmission()  {
		
		HomePage homepage = new HomePage(driver);
		ContactPage contactpage = homepage.clickContactLink();
		String Name = "Dan";
		contactpage.setFornameField(Name);
		contactpage.setEmailField("dan@abc.com");
		contactpage.setMessageField("Nice Pizza");
		contactpage.ClickSubmit();
		Assert.assertEquals("Thanks " + Name + ", we appreciate your feedback",contactpage.getSuccessMessage());
		
		}
	
	

}
