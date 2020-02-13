package tdd.racingcar;

import java.util.function.Consumer;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.Record;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.util.OutputUtils;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		final Cars cars = CarsFactory.create(InputView.inputNames());
		final TryCount tryCount = new TryCount(InputView.inputTryCount());
		final Record record = new Record();

		tryCount.forEachRemaining(startRound(cars, record));

		OutputView.printResultMessage();
		OutputView.printRecord(record.toString());
		OutputView.printWinners(OutputUtils.getWinners(cars));
	}

	private static Consumer<Integer> startRound(final Cars cars, final Record record) {
		return (count) -> {
			cars.move();
			record.append(OutputUtils.getState(cars));
		};
	}
}
