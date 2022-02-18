package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

	@Test
	@DisplayName("자동차 경주 게임 시작")
	public void startTest() {
		List<Car> cars = List.of(Car.of("lala"), Car.of("pobi"));
		AttemptNumber attemptNumber = AttemptNumber.of("2");
		RacingGame game = RacingGame.of(cars, attemptNumber);
		List<Car> racingCars = game.start(bound -> 5);

		racingCars.stream()
			.map(CarDto::of)
			.collect(Collectors.toList())
			.forEach(car -> {
				Assertions.assertThat(car.getPosition()).isEqualTo(attemptNumber.value());
			});
	}
}
