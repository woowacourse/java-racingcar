package racingcargame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;

public class CarTest {
	private Car car;

	@BeforeEach
	void setUp() {
		car = new Car("car");
	}

	@Test
	@DisplayName("convertToCarDto 테스트")
	void convertToCarDtoTest() {
		Assertions.assertThat(car.convertToCarDto()).isEqualTo(new CarDto("car", 0));
	}

	@Test
	@DisplayName("move 테스트")
	void moveTest() {
		Assertions.assertThat(car.move()).isEqualTo(1);
	}
}
