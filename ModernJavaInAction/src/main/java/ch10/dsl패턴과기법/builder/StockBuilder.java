package ch10.dsl패턴과기법.builder;

import ch10.dsl패턴과기법.Stock;
import ch10.dsl패턴과기법.Trade;

/**
 * 주식을 생성하는 빌더
 */
public class StockBuilder {

	private final MethodChainingOrderBuilder builder;
	private final Trade trade;
	private final Stock stock = new Stock();

	public StockBuilder(MethodChainingOrderBuilder builder, Trade trade, String symbol) {
		this.builder = builder;
		this.trade = trade;
		stock.setSymbol(symbol);
	}

	// 주식의 시장을 지정, 거래에 주식을 추가하고, 최종 빌더를 반환
	public TradeBuilderWithStock on(String market) {
		stock.setMarket(market);
		trade.setStock(stock);
		return new TradeBuilderWithStock(builder, trade);
	}

}
