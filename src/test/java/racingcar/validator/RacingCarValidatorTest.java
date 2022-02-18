package racingcar.validator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.MovingPolicy;
import racingcar.domain.RandomMovingPolicy;

public class RacingCarValidatorTest {
	private final MovingPolicy movingPolicy = new RandomMovingPolicy();

	@DisplayName("차 한대 인지 확인하기")
	@Test
	void validateCars_한대() {
		final List<Car> cars = Collections.singletonList(new Car("잉"));

		assertThatThrownBy(() -> {
			RacingCarValidator.validateCars(cars);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("차 중복되는지 확인하기")
	@Test
	void validateCars_중복() {
		final List<Car> cars = Arrays.asList(
			new Car("소니"),
			new Car("잉"),
			new Car("소니")
		);

		assertThatThrownBy(() ->{
			RacingCarValidator.validateCars(cars);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
