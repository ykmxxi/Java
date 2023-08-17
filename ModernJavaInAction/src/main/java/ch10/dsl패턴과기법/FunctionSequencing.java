package ch10.dsl패턴과기법;

import static ch10.dsl패턴과기법.sequencing.LambdaOrderBuilder.order;

public class FunctionSequencing {

	public static void main(String[] args) {
		// 함수 시퀀싱으로 주식 거래 생성
		Order order = order(o -> {
			o.forCustomer("BigBank");
			o.buy(t -> {
				t.quantity(80);
				t.price(125.00);
				t.stock(s -> {
					s.symbol("IBM");
					s.market("NYSE");
				});
			});
			o.sell(t -> {
				t.quantity(100);
				t.price(375.00);
				t.stock(s -> {
					s.symbol("GOOGLE");
					s.market("NASDAQ");
				});
			});
		});
	}

}
