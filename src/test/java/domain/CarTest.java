package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	@Test
	void isMove_전진_성공() {
		Car car = new Car("타미");
		assertThat(car.move(new RandomNo(4))).isTrue();
	}

	@Test
	void isMove_전진_실패() {
		Car car = new Car("타미");
		assertThat(car.move(new RandomNo(3))).isFalse();
	}

	@Test
	void isSamePositionTest_일치할_때() {
		Car car = new Car("타미", 1);
		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	void isSamePositionTest_불일치할_때() {
		Car car = new Car("타미", 1);
		assertThat(car.isSamePosition(0)).isFalse();
	}
}
