package ch10.dsl패턴과기법.sequencing;

import java.util.function.Consumer;

import ch10.dsl패턴과기법.Order;
import ch10.dsl패턴과기법.Trade;

/**
 * 함수 시퀀싱 DSL을 제공하는 주문 빌더
 * Consumer 객체를 빌더가 인수로 받음
 */
public class LambdaOrderBuilder {

	private Order order = new Order();

	public static Order order(Consumer<LambdaOrderBuilder> consumer) {
		LambdaOrderBuilder builder = new LambdaOrderBuilder();
		consumer.accept(builder); // 주문 빌더로 전달된 람다 표현식을 실행
		return builder.order; // Consumer를 실행해 만들어진 주문을 반환
	}

	public void forCustomer(String customer) {
		order.setCustomer(customer);
	}

	public void buy(Consumer<TradeBuilder> consumer) {
		trade(consumer, Trade.Type.BUY);
	}

	public void sell(Consumer<TradeBuilder> consumer) {
		trade(consumer, Trade.Type.SELL);
	}

	private void trade(Consumer<TradeBuilder> consumer, Trade.Type type) {
		TradeBuilder tradeBuilder = new TradeBuilder();
		tradeBuilder.trade.setType(type);
		consumer.accept(tradeBuilder); // TradeBuilder로 전달할 람다 표현식 실행
		order.addTrade(tradeBuilder.trade);
	}

}
