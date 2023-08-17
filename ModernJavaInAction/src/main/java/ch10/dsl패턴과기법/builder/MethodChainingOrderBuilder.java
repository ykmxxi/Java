package ch10.dsl패턴과기법.builder;

import ch10.dsl패턴과기법.Order;
import ch10.dsl패턴과기법.Trade;

/**
 * 메서드 체인 DSL을 제공하는 주문 빌더
 */
public class MethodChainingOrderBuilder {

	// 빌더로 감싼 주문
	public final Order order = new Order();

	public static MethodChainingOrderBuilder forCustomer(String customer) {
		return new MethodChainingOrderBuilder(customer);
	}

	// 고객의 주문을 만드는 정적 팩토리 메서드
	private MethodChainingOrderBuilder(String customer) {
		order.setCustomer(customer);
	}

	// 주식을 사는 TradeBuilder 생성
	public TradeBuilder buy(int quantity) {
		return new TradeBuilder(this, Trade.Type.BUY, quantity);
	}

	// 주식을 파는 TradeBuilder 생성
	public TradeBuilder sell(int quantity) {
		return new TradeBuilder(this, Trade.Type.SELL, quantity);
	}

	// 주문에 주식을 추가
	public MethodChainingOrderBuilder addTrade(Trade trade) {
		order.addTrade(trade);
		return this; // 추가 주문을 만들어 추가할 수 있도록 빌더 자체를 반환
	}

	// 주문 생성을 종료하고 반환
	public Order end() {
		return order;
	}

}
