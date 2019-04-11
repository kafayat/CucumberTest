package com.pizza.Menu;

public class MatchByRibbon implements MatchStrategy {
	
	private String ribbonText;
	
	public MatchByRibbon(String ribbonText)
	{
		this.ribbonText= ribbonText;
	}

	
	@Override
	public Boolean matchProduct(Item item) {
		return(item.getRibbonText().equals(ribbonText));
	}

}
