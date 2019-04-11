package com.pizza.Menu;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pizza.test.BaseTestSuite;


public class Item {
	
	private WebElement items;
	private WebDriver driver;
	
	public Item(WebElement items, WebDriver driver) {
		this.items = items;
		this.driver = driver;
	}
	
	By ribbon = By.className("ribbon-top-left");
	By title = By.cssSelector(".menuItem h3 span");
	By productImage = By.tagName("img");
	By kilojoules = By.className("kilojoules");
	By productName = By.className("name");
	By price = By.className("price");
	By veganIcon = By.cssSelector("span .orange");
	By vegetarianIcon = By.cssSelector("span .green");
	By addtoOrdertButton = By.cssSelector("button[aria-label='Add to order']");
	By StarRating = By.cssSelector("div.v-rating > i");
	
	public String getTitle() {
		return items.findElement(title).getText();
	}
	
	public String getImageAltTag() {
		return items.findElement(productImage).getAttribute("alt").toString();
	}
	
	public String getRibbonText() {				
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		String ribbonText = items.findElements(ribbon).size()>0 ?
						driver.findElement(ribbon).getText() : "";		
		driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return ribbonText;
	}
	
	public String getItemName() {
		String itemName = items.findElement(productName).getText();
		String lines[] = itemName.split("\\r?\\n");
		return lines[0].trim();
	}
	
	public String getProductKilojoules() {
		return items.findElement(kilojoules).getText();
	}
	
	public String getProductPrice() {
		return items.findElement(price).getText();
	}
	
	public Boolean getVeganPizza() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean isVegan = items.findElements(veganIcon).size()>0 ? true : false;
		driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return isVegan;
		
	}
	
	public Boolean getVegetarianPizza() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean isVegetarian = items.findElements(vegetarianIcon).size()>0?
				true : false;
		driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return isVegetarian;
	}
	
	public void clickOrderButton() {
		items.findElement(addtoOrdertButton).click();
	}
	
	

	public int getStarRating() {
		int starCount = 0;
		List<WebElement> stars = items.findElements(StarRating);
		for (WebElement star : stars) {
			if (star.getText().equals("star")){
				starCount ++;
			}
		}
		return starCount;
	}
	
	public void ClickStar(int starposition) {
		
		starposition = starposition > 0 ? starposition -1 : 0;
		List<WebElement> stars = items.findElements(StarRating);
		Actions actions = new Actions(driver);
		actions.moveToElement(stars.get(starposition));
		actions.sendKeys("");
		actions.click();
		actions.build().perform();
		
		
	}
	
}
