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
		List<Car> cars = List.of(Car.from("lala"), Car.from("pobi"));
		Attempt attempt = Attempt.fromStringValue("2");
		RacingGame game = RacingGame.of(cars, attempt);
		List<Car> racingCars = game.start(bound -> 5);

		racingCars.stream()
			.map(Car::toDto)
			.collect(Collectors.toList())
			.forEach(car -> {
				Assertions.assertThat(car.getPosition()).isEqualTo(attempt.getNumber());
			});
	}
}
