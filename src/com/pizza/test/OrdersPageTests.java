package com.pizza.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.pizza.Menu.Item;
import com.pizza.Menu.MatchByTitle;
import com.pizza.pages.HomePage;
import com.pizza.pages.MenuItemPage;
import com.pizza.pages.OrderPage;

public class OrdersPageTests  extends BaseTestSuite{

	
	@Test
	public void orderSubtotalValidation() throws Exception {
													
		HomePage homePage = new HomePage(driver);
		MenuItemPage menuPage = homePage.clickMenuLink();
		menuPage.clickDrinkTab();
		List<Item> menuItems = menuPage.getMenuItems(new MatchByTitle("Espresso Thickshake"));
		menuItems.get(0).clickOrderButton();
		menuPage.clickPizzaTab();
		menuItems = menuPage.getMenuItems(new MatchByTitle("Margherita"));
		menuItems.get(0).clickOrderButton();
		menuItems.get(0).clickOrderButton();
		
	   	Assert.assertEquals("The order count is not correct", "3",menuPage.getOrderCount()); 
		OrderPage orderPage = menuPage.clickOrderLink();
		Assert.assertEquals("subtotal was incorrect","4.99", orderPage.getItemSubtotal("Espresso Thickshake"));
	
	
		
	}
}
