package com.pizza.Menu;

public class MatchByVegan implements MatchStrategy{
	
	
	@Override
	public Boolean matchProduct(Item item) {
		// TODO Auto-generated method stub
		return item.getVeganPizza();
	}

}
