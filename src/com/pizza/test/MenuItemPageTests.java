package com.pizza.test;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import com.pizza.Menu.Item;
import com.pizza.Menu.MatchByRibbon;
import com.pizza.Menu.MatchByStar;
import com.pizza.Menu.MatchByTitle;
import com.pizza.Menu.MatchByVegan;
import com.pizza.dialog.LoginDialog;
import com.pizza.pages.HomePage;
import com.pizza.pages.MenuItemPage;




public class MenuItemPageTests extends BaseTestSuite {
	
	
	@Test
	public void ValidateNewItems() throws Exception {
		
		HomePage homepage = new HomePage(driver);
		MenuItemPage menupage = homepage.clickMenuLink();
		menupage.clickSideTab();
	
		List<Item> items = menupage.getMenuItems(new MatchByRibbon("NEW"));
		
		Assert.assertEquals("Name of the new item is not correct", "Korean Sticky Wings",
				items.get(0).getTitle());
		
	      Assert.assertEquals("Image alt tag of the new item is not correct", "Korean Sticky Wings",
				items.get(0).getImageAltTag());
		
	}
	
	@Test
	public void ValidItemByKilojoulesAndPrice() throws Exception {
		HomePage homepage = new HomePage(driver);
		MenuItemPage menupage = homepage.clickMenuLink();
		menupage.clickSideTab();
	    List<Item> items = menupage.getMenuItems(new MatchByTitle("Chunky Chips and Aioli"));
        Assert.assertEquals("Kilojoules are incoorect", "3273 kJ", items.get(0).getProductKilojoules());
        Assert.assertEquals("Item price is incoorect", "$9.99",items.get(0).getProductPrice());
	}
	
	
	@Test
	public void ValidVeganPizzaPrice() throws Exception {
		HomePage homepage = new HomePage(driver);
		MenuItemPage menupage = homepage.clickMenuLink();
		menupage.clickPizzaTab();
		List<Item> items = menupage.getMenuItems(new MatchByVegan());
		for(Item menuItem : items) {
			//Assert.assertEquals(menuItem.getProductPrice(), "$14.99", "price of " + menuItem.getItemName() + " is not correct");
			Assert.assertEquals(menuItem.getProductPrice(), "$14.99");
		}
		
	}
	@Test
	public void MenuItemStarRating() throws Exception {
		HomePage homepage = new HomePage(driver);
		MenuItemPage menupage = homepage.clickMenuLink();
		menupage.clickDrinkTab();
		List<Item> items = menupage.getMenuItems(new MatchByStar(0));
		items.get(0).ClickStar(3);
		Assert.assertEquals("All star did not have 0 rating ",items.get(0).getStarRating(), 0);
		
		LoginDialog loginDialog = menupage.clickLoginLink();
		loginDialog.setUserName("bob");
		loginDialog.setPassowrd("ilovepizza");
		loginDialog.ClickLogin();
		
		items.get(0).ClickStar(3);
		Assert.assertEquals("Incorrect number of stars ",items.get(0).getStarRating(), 3);
		
		
	}
	


}
