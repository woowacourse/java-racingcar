package racingcar.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Round;
import racingcar.service.dto.CarDto;

public class RacingGameTest {

	@Test
	@DisplayName("자동차 경주 게임 시작")
	public void startTest() {
		List<CarDto> cars = List.of(CarDto.of("lala"), CarDto.of("pobi"));
		AttemptNumber attemptNumber = AttemptNumber.of("2");
		RacingGame game = RacingGame.of(cars, attemptNumber);
		game.start(() -> 5);
		List<CarDto> racingCars = game.findRacingResult(Round.of(2));
		racingCars.forEach(car -> Assertions.assertThat(car.getPosition()).isEqualTo(attemptNumber.value()));
	}
}
