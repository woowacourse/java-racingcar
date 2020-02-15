package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomConstructor;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRacing {
	private static final int INDEX_INIT = 0;

	public static void main(String[] args) {
		String inputNames = InputView.receiveNameInput();
		Cars cars = new Cars(inputNames);
		int count = InputView.receiveCountInput();

		OutputView.showResult();
		showEachRaceResult(cars, count);
		OutputView.showWinner(cars.getWinners());
	}

	protected static void showEachRaceResult(Cars cars, int count) {
		RandomConstructor randomConstructor = new RandomConstructor();

		for (int i = INDEX_INIT; i < count; i++) {
			race(cars, randomConstructor);
			OutputView.showRace(cars.getCars());
		}
	}

	private static void race(Cars cars, RandomConstructor randomConstructor) {
		for (Car car : cars.getCars()) {
			int randomValue = randomConstructor.getRandomNumber();
			car.movePositionAccordingToCondition(randomValue);
		}
	}
}
