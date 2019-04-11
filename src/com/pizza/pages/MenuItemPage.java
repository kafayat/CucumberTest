package com.pizza.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizza.Menu.Item;
import com.pizza.Menu.MatchByRibbon;
import com.pizza.Menu.MatchStrategy;

import utils.Utilites;

public class MenuItemPage extends BaseNavigation {

	public MenuItemPage(WebDriver item) {
		super(item);
		// TODO Auto-generated constructor stub
	}
	
	
	By sidesTabLink = By.partialLinkText("SIDES");
	By pizzaTabLink = By.partialLinkText("PIZZAS");
	By drinksTabLink = By.partialLinkText("DRINKS");
	By sideList = By.cssSelector("div.sides-tab");
	By menuItemsContainer = By.className("v-window-item");
	By menuItem = By.className("menuItem"); 
	By sidesTabPage = By.className("sides-tab");
	By pizzaTabPage = By.className("pizza-tab");
	By drinksTabPage = By.className("drinks-tab");
	
	
	
	public void clickSideTab() {
	    driver.findElement(sidesTabLink ).click();
	    waitForItemsToDisplay(sidesTabPage);
	}
	
	public void clickPizzaTab() {
	    driver.findElement(pizzaTabLink ).click();
	   // waitForItemsToDisplay(pizzaTabPage);
	}
	
	public void clickDrinkTab() {
	    driver.findElement(drinksTabLink ).click();
	    waitForItemsToDisplay(drinksTabPage);
	}
	
	private void waitForItemsToDisplay(By expectedTab) {
		//wait for the expected tab to display
		(new WebDriverWait(driver, 3))
		.until(ExpectedConditions.visibilityOfElementLocated(expectedTab));
		
		//wait for the tab to contain visible menu items
		(new WebDriverWait(driver, 3)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	try {
            		//true if there are 
					return visibleMenuItems() > 0;
				} catch (Exception e) {
					return d.findElement(menuItemsContainer).getText().length() != 0;
				}
            }
        });
	}
	
	private int visibleMenuItems() throws Exception {
		int visibleCount = 0;
		WebElement visibleContainer = getVisibleMenuItemPage();
		List<WebElement> items = visibleContainer.findElements(menuItem);
		for(WebElement item : items) {
			if (item.isDisplayed()) {
				visibleCount ++;
			}
		}
		return visibleCount;
	}
	
	private WebElement getVisibleMenuItemPage() throws Exception {
		List<WebElement> items = driver.findElements(menuItemsContainer);
		for(WebElement item:items) {
			if(item.isDisplayed()) {
				return item;
				}
		}
		throw new Exception("Page is not visible");
	}
	private WebElement getVisibleItemContainer() throws Exception {
		List<WebElement> itemContainers = driver.findElements(menuItemsContainer);
		for(WebElement itemContainer : itemContainers) {
			if (itemContainer.isDisplayed()) {
				return itemContainer;
			}
		}
		throw new Exception("no visible container found");
	} 
	
	
	
	public List<Item> getMenuItems(MatchStrategy strategy) throws Exception{
	    List<Item> menuitems = new ArrayList<>();
		WebElement visibleContainer = getVisibleItemContainer();
		List<WebElement> items = visibleContainer.findElements(menuItem);
		for(WebElement item : items) {
			if(items.size() > 0)
			{
				
			Item menuitem  = new Item(item, driver);
			if (strategy.matchProduct(menuitem)) {
				
				menuitems.add(menuitem);}
						
			}
						
		}
		return menuitems;
		
	}
	
	


	
	

	
		
	
	
}
	
	
	

