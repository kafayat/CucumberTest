package com.pizza.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pizza.tables.TableHelper;

public class OrderPage  extends BaseNavigation{

	public OrderPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
		waitForTableToDisplay();
			
	}
	By orderTable = By.className("v-datatable");
	
	public String getItemSubtotal(String itemName) throws Exception {
		
		WebElement table = driver.findElement(orderTable);
		TableHelper tableHelper = new TableHelper(table);
		List <WebElement> tableCells = tableHelper.getItemRowCells(itemName,"Name");
		int subTotalColumn = tableHelper.getColumnIndex("Subtotal");
		return tableCells.get(subTotalColumn).getText();
		
	}
	
	private void waitForTableToDisplay() {
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(orderTable).getText().length() != 0;
            }
        });
	}
	
	
	
	
}
