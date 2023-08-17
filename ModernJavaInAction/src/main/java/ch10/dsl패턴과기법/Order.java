package ch10.dsl패턴과기법;

import java.util.ArrayList;
import java.util.List;

/**
 * 도메인 3: 고객이 요청한 한 개 이상의 거래 주문
 */
public class Order {

	private String customer;
	private List<Trade> trades = new ArrayList<>();

	public void addTrade(Trade trade) {
		trades.add(trade);
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getValue() {
		return trades.stream()
			.mapToDouble(Trade::getValue)
			.sum();
	}

}
