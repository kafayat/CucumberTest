Feature: Login
	Check if login functionality works
	
@mylogin

Scenario: verify Login Credentials
	Given I navigate to LoginLink
	And I enter the following for Login
	
			|Username| Password |
			|		bob	 | ilovepizza |
	
	And I click login
	Then I should see user logged in to the application