package racingcargame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.MoveStrategy;
import racingcargame.domain.NumberGenerator;
import racingcargame.domain.car.Car;
import racingcargame.domain.car.CarDto;

class CarTest {
	private MoveStrategy moveStrategy;
	private Car car;

	@BeforeEach
	void setUp() {
		moveStrategy = new NumberGenerator();
		car = new Car("car");
	}

	@Test
	@DisplayName("생성자 테스트")
	void constructor() {
		Assertions.assertThat(new Car("car")).isInstanceOf(Car.class);
	}

	@Test
	@DisplayName("convertToCarDto 테스트")
	void convertToCarDtoTest() {
		Assertions.assertThat(car.convertToCarDto()).isEqualTo(new CarDto("car", 0));
		car.decideMoveOrStop(moveStrategy.getMoveNo());
		Assertions.assertThat(car.convertToCarDto()).isEqualTo(new CarDto("car", 1));
	}

	@Test
	@DisplayName("decideMoveOrStop 테스트")
	void decideMoveOrStopTest() {
		Assertions.assertThat(car.decideMoveOrStop(moveStrategy.getMoveNo())).isNotEqualTo(0);
		Assertions.assertThat(car.decideMoveOrStop(moveStrategy.getStopNo())).isEqualTo(1);
	}
}
