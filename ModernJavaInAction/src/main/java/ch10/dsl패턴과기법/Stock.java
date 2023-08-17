package ch10.dsl패턴과기법;

/**
 * 도메인 1: 주어진 시장에 주식 가격을 모델링하는 순수 자바 빈즈
 */
public class Stock {

	private String symbol;
	private String market;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

}
