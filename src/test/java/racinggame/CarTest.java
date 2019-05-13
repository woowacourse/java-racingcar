package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racinggame.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
	Car car;

	@BeforeEach
	void setup() {
		car = new Car("bmo");
	}

	@Test
	void 생성() {
		assertThat(car).isEqualTo(new Car("bmo", 0));
		car.move(true);
		assertThat(car).isEqualTo(new Car("bmo", 1));
	}

	@Test
	void 이름길이() {
		assertThat(car.checkCarNameLength("12345")).isEqualTo(true);
		assertThat(car.checkCarNameLength("123456")).isEqualTo(false);
	}

	@Test
	void move() {
		assertThat(car.matchPosition(0)).isEqualTo(true);
		car.move(false);
		assertThat(car.matchPosition(0)).isEqualTo(true);
		car.move(true);
		assertThat(car.matchPosition(0)).isEqualTo(false);
	}

	@AfterEach
	void tearDown() {
		car = null;
	}
}
