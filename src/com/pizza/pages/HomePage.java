package com.pizza.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseNavigation {

	By ordernowbutton = By.xpath("//div[@class='flex pa-0 xs12'] // a");
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	 public static void NaivgatetoUrl(String url) {
		 driver.navigate().to(url);
	    	
	    }

}
