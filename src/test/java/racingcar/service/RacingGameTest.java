package racingcar.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Round;
import racingcar.service.dto.CarDto;

public class RacingGameTest {

	private RacingGame racingGame;
	private AttemptNumber attemptNumber;

	@BeforeEach
	public void beforeEach() {
		List<CarDto> cars = List.of(CarDto.of("lala"), CarDto.of("pobi"));
		attemptNumber = AttemptNumber.of("2");
		racingGame = RacingGame.of(cars, attemptNumber);
	}

	@Test
	@DisplayName("자동차 경주 게임 시작")
	public void startTest() {
		racingGame.start(() -> 5);
		racingGame.start(() -> 5);

		Round round = Round.of(attemptNumber.value());
		List<CarDto> racingCars = racingGame.findRacingResult(round);
		racingCars.forEach(car -> {
			Assertions.assertThat(car.getPosition()).isEqualTo(attemptNumber.value());
		});
	}
}
