package stepDefination;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.pizza.dialog.LoginDialog;
import com.pizza.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;


public class LoginSteps {
	
	WebDriver driver;
	HomePage homepage;
	LoginDialog logindialog;
	private Hooks hooks;

    public LoginSteps(Hooks hooks){
        this.hooks = hooks;
       
    }
	@Given("I navigate to LoginLink")
	public void i_navigate_to_LoginLink() 
	{
		
		homepage = new HomePage(hooks.driver);
	//	logindialog = new LoginDialog(driver);
		homepage.clickLoginLink();
	//	logindialog.ClickLogin();
	//	Assert.assertEquals("Alert Message did not display correctly","Your login was unsuccessful - please try again",logindialog.GetAlertMessage());
	//	logindialog.ClickDismissIcon();
	//	Assert.assertEquals("Alert Message did not clear correctly","",logindialog.GetAlertMessage());
	}

	@Given("I enter the following for Login")
	public void i_enter_the_following_for_Login(DataTable dt) {
		System.out.println("i_click_login");
		
		/*
		List<String> list = dt.asList(String.class);
		System.out.println("Username - " + list.get(2));
		System.out.println("Password - " + list.get(3));*/
		
	}

	@Given("I click login")
	public void i_click_login() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("i_click_login");
	}

	@Then("I should see user logged in to the application")
	public void i_should_see_user_logged_in_to_the_application() {
		System.out.println("I should see user logged in to the application");
	}



}
