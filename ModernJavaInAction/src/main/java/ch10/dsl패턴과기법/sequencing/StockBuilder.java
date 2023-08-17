package ch10.dsl패턴과기법.sequencing;

import ch10.dsl패턴과기법.Stock;

public class StockBuilder {

	public Stock stock = new Stock();

	public void symbol(String symbol) {
		stock.setSymbol(symbol);
	}

	public void market(String market) {
		stock.setMarket(market);
	}

}
