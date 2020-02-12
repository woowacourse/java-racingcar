package tdd.racingcar;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.util.CarsUtils;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		final Cars cars = CarsFactory.create(InputView.inputNames());
		final TryCount tryCount = new TryCount(InputView.inputTryCount());

		OutputView.printResultMessage();
		while (tryCount.isRemain()) {
			cars.move();
			tryCount.consume();
			OutputView.printCar(CarsUtils.getState(cars));
		}
		OutputView.printWinners(CarsUtils.getWinners(cars));
	}
}
