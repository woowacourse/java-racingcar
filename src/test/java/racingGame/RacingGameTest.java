package racingGame;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.Name;

public class RacingGameTest {
	@Test
	void getWinners_우승한_자동차() {
		RacingGame racingGame = new RacingGame();
		List<Car> inGameCars = new ArrayList<>();
		Cars cars;
		int winnerPosition = 7;

		inGameCars.add(new Car(new Name("car1")));
		inGameCars.add(new Car(new Name("car2")));
		inGameCars.add(new Car(new Name("car3")));
		inGameCars.add(new Car(new Name("car4")));

		inGameCars.get(0).setPosition(winnerPosition - 1);
		inGameCars.get(1).setPosition(winnerPosition);
		inGameCars.get(2).setPosition(winnerPosition - 2);
		inGameCars.get(3).setPosition(winnerPosition);

		cars = new Cars(inGameCars);

		List<Car> actual = racingGame.getWinners(cars);

		List<Car> expected = Arrays.asList(
			new Car(new Name("car2")),
			new Car(new Name("car4")));

		assertThat(actual).isEqualTo(expected);
	}
}
