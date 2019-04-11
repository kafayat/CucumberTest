package com.pizza.Menu;

public class MatchByStar implements MatchStrategy{

	private int star;
	
	public MatchByStar(int star) {
		this.star = star;
	}
	
	@Override
	public Boolean matchProduct(Item item) {
		// TODO Auto-generated method stub
		return(item.getStarRating() == this.star);
	}

}
