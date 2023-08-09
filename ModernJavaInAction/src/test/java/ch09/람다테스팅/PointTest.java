package ch09.람다테스팅;

import static org.assertj.core.api.Assertions.assertThat;

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

}
