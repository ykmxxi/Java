package ch10.dsl패턴과기법;

import ch10.dsl패턴과기법.builder.MethodChainingOrderBuilder;

public class MethodChain {

	public static void main(String[] args) {
		// 고객 지정(forCustomer) -> buy or sell -> stock -> on -> at -> ... -> on -> at -> end
		Order order = MethodChainingOrderBuilder.forCustomer("BigBank")
			.buy(100) // 거래 1: 매수
			.stock("APPLE")
			.on("NYSE")
			.at(125.00)
			.sell(50) // 거래 2: 매도
			.stock("GOOGLE")
			.on("NASDAQ")
			.at(375.00)
			.end();
	}

}
