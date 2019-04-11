package com.pizza.Menu;

public class MatchByTitle implements MatchStrategy{
	
	private String itemTitle;
	
	public MatchByTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	@Override
	public Boolean matchProduct(Item item) {
		// TODO Auto-generated method stub
		return (item.getItemName().equals(itemTitle));
	}

}
