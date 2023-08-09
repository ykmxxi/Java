package ch09.디자인패턴리팩토링;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class FactoryPattern {

	public static void main(String[] args) {
		Product product = ProductFactory.createProduct("loan");
		product.print();
	}

}

class ProductFactory {

	static final Map<String, Supplier<Product>> map = new HashMap<>();

	static {
		map.put("loan", Loan::new);
		map.put("stock", Stock::new);
	}

	public static Product createProduct(String name) {
		switch (name) {
			case "loan":
				return new Loan();
			case "stock":
				return new Stock();
			default:
				throw new RuntimeException(name + " 상품이 없습니다");
		}
	}

	public static Product createProductLambda(String name) {
		Supplier<Product> supplier = map.get(name);

		if (supplier != null) {
			return supplier.get();
		}
		throw new IllegalArgumentException(name + " 상품이 없습니다");
	}

}

interface Product {

	void print();
}

class Loan implements Product {

	@Override
	public void print() {
		System.out.println("Loan 상품");
	}

}

class Stock implements Product {

	@Override
	public void print() {
		System.out.println("Stock 상품");
	}

}
