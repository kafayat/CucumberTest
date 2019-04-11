package com.pizza.tables;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TableHelper {
	private WebElement element;
	public TableHelper(WebElement element) {
		this.element = element;
	}
	
	By tableHeaderRow = By.cssSelector("thead th");
	By tableDataRow = By.cssSelector("tbody tr");
	By tableCell = By.tagName("td");
	
	public int getColumnIndex(String columnName) throws Exception{
		List<WebElement> tableHeaders = element.findElements(tableHeaderRow);
		for(int i=0;i<tableHeaders.size();i++){
			if (tableHeaders.get(i).getText().equals(columnName)){
				return i;
			}
		}
		throw new Exception(" No column titled " + columnName + " found");
	}
	
	public List<WebElement> getItemRowCells(String searchTerm, String fromColumn) throws Exception {
		int findColumnIndex = getColumnIndex(fromColumn);
		List<WebElement> tableRows = element.findElements(tableDataRow);
		for(WebElement row : tableRows){
			List<WebElement> tableCells = row.findElements(tableCell);	
			if (tableCells.get(findColumnIndex).getText().equals(searchTerm)){
				return tableCells;
			}
		}
		throw new Exception("No cell data found");	
	}
}
