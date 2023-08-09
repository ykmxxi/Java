package ch09.람다테스팅;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void moveRightByTest() {
		Point p1 = new Point(5, 5);
		Point p2 = p1.moveRightBy(10);

		assertThat(p2.getX()).isEqualTo(15);
		assertThat(p2.getY()).isEqualTo(5);
	}

	@Test
	@DisplayName("람다를 이용한 정적 필드 테스트")
	void comparingTwoPoints() {
		Point p1 = new Point(10, 15);
		Point p2 = new Point(10, 20);
		int result = Point.compareByXAndThenY.compare(p1, p2);

		assertThat(result < 0).isTrue();
	}

	@Test
	@DisplayName("람다를 사용하는 메서드의 동작에 집중: 람다를 공개하지 않고 테스트로 검증")
	void moveAllPointsRightBy() {
		List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
		List<Point> expected = Arrays.asList(new Point(15, 5), new Point(20, 5));

		List<Point> actual = Point.moveAllPointsRightBy(points, 10);
		assertThat(actual).containsAll(expected);
	}

}
