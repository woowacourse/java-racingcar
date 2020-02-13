package tdd.racingcar;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.Record;
import tdd.racingcar.domain.Records;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		final Cars cars = CarsFactory.create(InputView.inputNames());
		final TryCount tryCount = new TryCount(InputView.inputTryCount());
		final Records records = new Records();
		OutputView.printResultMessage();
		tryCount.forEachRemaining(count -> {
			cars.move();
			records.add(new Record(cars));
		});
		records.forEach(OutputView::printRecord);
		OutputView.printWinners(cars.getWinners());
	}
}
