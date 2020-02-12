package tdd.racingcar;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		final Cars cars = new Cars(InputView.inputNames());
		final TryCount tryCount = new TryCount(InputView.inputTryCount());

		OutputView.printResultMessage();
		while (tryCount.isRemain()) {
			cars.move();
			tryCount.consume();
			OutputView.printCars(cars);
		}

		OutputView.printWinners(cars.getWinners());
	}
}
