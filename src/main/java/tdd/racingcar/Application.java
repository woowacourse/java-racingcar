package tdd.racingcar;

import java.util.function.Consumer;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.Records;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.util.OutputUtils;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		Cars cars = CarsFactory.create(InputView.inputNames());
		TryCount tryCount = new TryCount(InputView.inputTryCount());
		Records records = new Records();

		tryCount.forEachRemaining(startRound(cars, records));

		OutputView.printResultMessage();
		OutputView.printRecord(records.toString());
		OutputView.printWinners(OutputUtils.getWinnerState(cars));
	}

	private static Consumer<Integer> startRound(Cars cars, Records records) {
		return (count) -> {
			cars.move();
			records.append(OutputUtils.getState(cars));
		};
	}
}
