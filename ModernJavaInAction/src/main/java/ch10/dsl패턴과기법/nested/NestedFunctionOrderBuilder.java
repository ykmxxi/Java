package ch10.dsl패턴과기법.nested;

import java.util.stream.Stream;

import ch10.dsl패턴과기법.Order;
import ch10.dsl패턴과기법.Stock;
import ch10.dsl패턴과기법.Trade;

/**
 * 중첩된 함수 DSL을 제공하는 주문 빌더
 */
public class NestedFunctionOrderBuilder {

	// 고객과 거래들을 받아 주문 생성
	public static Order order(String customer, Trade... trades) {
		Order order = new Order();
		order.setCustomer(customer);
		Stream.of(trades)
			.forEach(order::addTrade);
		return order;
	}

	// 매수 거래 생성
	public static Trade buy(int quantity, Stock stock, double price) {
		return buildTrade(quantity, stock, price, Trade.Type.BUY);
	}

	// 매도 거래 생성
	public static Trade sell(int quantity, Stock stock, double price) {
		return buildTrade(quantity, stock, price, Trade.Type.SELL);
	}

	// 거래 생성 빌더
	private static Trade buildTrade(int quantity, Stock stock, double price, Trade.Type type) {
		Trade trade = new Trade();
		trade.setQuantity(quantity);
		trade.setStock(stock);
		trade.setPrice(price);
		trade.setType(type);
		return trade;
	}

	// 거래된 주식의 단갈ㄹ 정의하는 더미 메서드
	public static double at(double price) {
		return price;
	}

	// 거래된 주식을 생성
	public static Stock stock(String symbol, String market) {
		Stock stock = new Stock();
		stock.setSymbol(symbol);
		stock.setMarket(market);
		return stock;
	}

	// 주식이 거래된 시장을 정의하는 더미 메서드
	public static String on(String market) {
		return market;
	}

}
