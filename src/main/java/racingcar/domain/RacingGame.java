package racingcar.domain;

import racingcar.utils.RandomGenerator;
import racingcar.view.OutputView;

public class RacingGame {
	private static final int INDEX_INIT = 0;

	public static void showEachRaceResult(Cars cars, int count) {
		for (int i = INDEX_INIT; i < count; i++) {
			race(cars);
			OutputView.showRace(cars.getCars());
		}
	}

	private static void race(Cars cars) {
		for (Car car : cars.getCars()) {
			int randomValue = RandomGenerator.getRandomNumber();
			car.movePositionAccordingToCondition(randomValue);
		}
	}
}
