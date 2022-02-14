package racingcargame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

	@DisplayName("RacingCarGame객체가 정상적으로 생성되는지 테스트")
	@Test
	void createObject_RacingCarGame() {
		List<String> carNames = List.of("토미", "제인", "데이빗");
		int raceCount = 5;
		RacingCarGame racingCarGame = new RacingCarGame(carNames, raceCount);

		HashMap<String, Integer> carsPosition = racingCarGame.sendCurrentPositionOfRacingCars();
		carsPosition.forEach((carName, carPosition) -> {
			assertThat(carNames).contains(carName);
			assertThat(carPosition).isEqualTo(0);
		});

		assertThat(racingCarGame.isOverRace()).isEqualTo(false);
	}

	@DisplayName("경주가 정상적으로 끝나는지 테스트")
	@Test
	void isOverRace() {
		List<String> carNames = List.of("토미", "제인", "데이빗");
		int raceCount = 5;
		RacingCarGame racingCarGame = new RacingCarGame(carNames, raceCount);

		IntStream.range(0, 5).forEach(index -> racingCarGame.startRace());

		assertThat(racingCarGame.isOverRace()).isEqualTo(true);
	}
}