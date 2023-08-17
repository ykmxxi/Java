package ch10.dsl패턴과기법;

/**
 * 도메인 객체의 API를 직접 이용해 주식 거래 주문 생성
 */
public class Version1 {

	public static void main(String[] args) {
		// 주문 고객을 설정
		Order order = new Order();
		order.setCustomer("BigBank");

		// 거래 생성
		Trade trade1 = new Trade();
		trade1.setType(Trade.Type.BUY);

		// 거래할 주식 생성
		Stock stock1 = new Stock();
		stock1.setSymbol("APPLE");
		stock1.setMarket("NYSE");

		// 거래 정보 설정
		trade1.setStock(stock1);
		trade1.setPrice(125.00);
		trade1.setQuantity(100);

		// 주문 설정
		order.addTrade(trade1);
	}

}
