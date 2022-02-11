package racingcar;

import java.util.Random;
import java.util.Set;

public class Game {
	public void start() {
		Set<Car> cars = CarFactory.of(InputView.inputCarNames());
		int count = InputView.inputGameCount();
		OutputView.printGameResultTitle();
		play(cars);
		showResult(cars);
	}

	public Set<Car> play(Set<Car> cars) {
		for (Car car : cars) {
			Referee.judgeCarMove(car, makeRandomValue());
		}
		return cars;
	}

	public void showResult(Set<Car> cars) {
		for (Car car : cars) {
			OutputView.printLineString(car.toString());
		}
		OutputView.printBlankLine();
	}

	public int makeRandomValue() {
		Random random = new Random();
		return random.nextInt(10);
	}
}
