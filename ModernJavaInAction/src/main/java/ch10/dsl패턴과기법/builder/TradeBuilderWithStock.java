package ch10.dsl패턴과기법.builder;

import ch10.dsl패턴과기법.Trade;

public class TradeBuilderWithStock {

	private final MethodChainingOrderBuilder builder;
	private final Trade trade;

	public TradeBuilderWithStock(MethodChainingOrderBuilder builder, Trade trade) {
		this.builder = builder;
		this.trade = trade;
	}

	// 거래되는 주식의 단위 가격을 설정한 다음 원래 주문 빌더를 반환
	public MethodChainingOrderBuilder at(double price) {
		trade.setPrice(price);
		return builder.addTrade(trade);
	}

}
