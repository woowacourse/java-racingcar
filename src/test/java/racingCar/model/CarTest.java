package racingCar.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
	public Car car = new Car("jiwoo");

	CarTest() throws Exception {
	}

	@Test
	void move_후_위치확인_잘되는지_검사() {
		car.move();
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	void getName_잘되는지_검사() {
		assertThat(car.getName()).isEqualTo("jiwoo");
	}

	@Test
	void 특정위치여부_확인_잘되는지_검사() {
		car.move();
		assertThat(car.isSamePosition(1)).isTrue();
	}

	@Test
	void 차_상태확인_잘되는지_검사() {
		car.move();
		car.move();
		assertThat(car.getStateString()).isEqualTo("jiwoo : --\n");
	}
}