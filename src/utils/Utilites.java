package utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizza.test.BaseTestSuite;

public class Utilites {
	
	
    
	
public static Boolean elementExists(WebDriver driver,By locator,long timeoutSec,long timeoutMS) {
		
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			//check for existence of element
			(new WebDriverWait(driver, timeoutSec, timeoutMS))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			//check that its visible
			(new WebDriverWait(driver, timeoutSec, timeoutMS))
			.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			//re enable timeout
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
			return true;		
		}
		catch (Exception e){
			//reset timeout on exception
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
			return false;
		}		
	}

	public static void moveToElement(WebDriver driver, By locator) { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(locator));
		actions.sendKeys("");
		actions.build().perform(); 	} 

	public static String randomString(String chars, int length) {
			Random rand = new Random();
			StringBuilder sb = new StringBuilder();
				for (int i=0; i<length; i++) {
					sb.append(chars.charAt(rand.nextInt(chars.length())));
				  }
				  return sb.toString();
				}
   

	public static Boolean elementLocatorExists(WebDriver driver, By locator, long timeoutSec, long pollingMS) {
		try {
			//disable timeout
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			
			//check for existence of element
			(new WebDriverWait(driver, timeoutSec, pollingMS))
			.until(ExpectedConditions.presenceOfElementLocated(locator));
			//check that its visible
			(new WebDriverWait(driver, timeoutSec, pollingMS))
			.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			//re enable timeout
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
			//return true
			return true;
			} catch (Exception e) {
				//reset timeout on exception
				driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
				//return false
				return false;
			}
	}
}
	


