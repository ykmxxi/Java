package ch09.람다테스팅;

import static java.util.Comparator.comparing;

import java.util.Comparator;

public class Point {

	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point moveRightBy(int x) {
		return new Point(this.x + x, this.y);
	}

	public final static Comparator<Point> compareByXAndThenY = comparing(Point::getX).thenComparing(Point::getY);

}
