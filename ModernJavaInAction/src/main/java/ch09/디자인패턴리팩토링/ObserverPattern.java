package ch09.디자인패턴리팩토링;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

	public static void main(String[] args) {
		Feed feed = new Feed();
		feed.registerObserver(new NYTimes());
		feed.registerObserver(new Guardian());
		feed.registerObserver(new LeMonde());

		String tweet = "The queen said her favorite book is Moder Java in Action!!!";
		feed.notifyObservers(tweet); // Guardian의 notify 메서드가 수행된다

		// 람다 표현식으로 직접 전달해 실행할 동작을 지정하기
		feed.registerObserver((String s) -> {
			if (s != null && s.contains("Hollywood")) {
				System.out.println("Breaking News in Hollywood!!! " + s);
			}
		});
		feed.notifyObservers("Hollywood");
	}

}

interface Observer {

	void notify(String tweet);

}

class NYTimes implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null && tweet.contains("money")) {
			System.out.println("NewYork Times 속보!! " + tweet);
		}
	}

}

class Guardian implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null && tweet.contains("queen")) {
			System.out.println("London News... " + tweet);
		}
	}

}

class LeMonde implements Observer {

	@Override
	public void notify(String tweet) {
		if (tweet != null && tweet.contains("wine")) {
			System.out.println("World's best wine! " + tweet);
		}
	}

}

interface Subject {

	void registerObserver(Observer observer);

	void notifyObservers(String tweet);

}

class Feed implements Subject {

	private final List<Observer> observers = new ArrayList<>();

	@Override
	public void registerObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void notifyObservers(String tweet) {
		observers.forEach(o -> o.notify(tweet));
	}

}
