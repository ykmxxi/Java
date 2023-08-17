package ch10.dsl패턴과기법.sequencing;

import java.util.function.Consumer;

import ch10.dsl패턴과기법.Trade;

public class TradeBuilder {

	public Trade trade = new Trade();

	public void quantity(int quantity) {
		trade.setQuantity(quantity);
	}

	public void price(double price) {
		trade.setPrice(price);
	}

	public void stock(Consumer<StockBuilder> consumer) {
		StockBuilder builder = new StockBuilder();
		consumer.accept(builder);
		trade.setStock(builder.stock);
	}

}
