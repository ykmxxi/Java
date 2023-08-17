package ch10.dsl패턴과기법.builder;

import ch10.dsl패턴과기법.Trade;

/**
 * Stock 클래스의 인스턴스를 만드는 거래 빌더
 */
public class TradeBuilder {

	private final MethodChainingOrderBuilder builder;
	public final Trade trade = new Trade();

	public TradeBuilder(MethodChainingOrderBuilder builder, Trade.Type type, int quantity) {
		this.builder = builder;
		trade.setType(type);
		trade.setQuantity(quantity);
	}

	public StockBuilder stock(String symbol) {
		return new StockBuilder(builder, trade, symbol);
	}

}
