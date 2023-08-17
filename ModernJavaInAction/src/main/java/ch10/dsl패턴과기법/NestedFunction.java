package ch10.dsl패턴과기법;

import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.at;
import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.buy;
import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.on;
import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.order;
import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.sell;
import static ch10.dsl패턴과기법.nested.NestedFunctionOrderBuilder.stock;

public class NestedFunction {

	public static void main(String[] args) {
		// 중첩된 함수로 주식 거래 생성
		Order order = order("BigBank",
			buy(100, stock("IBM", on("NYSE")), at(125.00)),
			sell(50, stock("GOOGLE", on("NASDAQ")), at(375.00))
		);
	}

}
