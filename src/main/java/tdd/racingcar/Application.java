package tdd.racingcar;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.Record;
import tdd.racingcar.domain.Records;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(String[] args) {
		final Cars cars = CarsFactory.create(InputView.inputNames());
		TryCount tryCount = new TryCount(InputView.inputTryCount());
		Records records = new Records();
		tryCount.forEachRemaining(count -> {
			cars.move();
			records.add(new Record(cars));
		});
		OutputView.printRecords(records);
		OutputView.printWinners(cars.getWinners());
	}
}
