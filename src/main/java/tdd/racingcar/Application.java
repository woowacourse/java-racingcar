package tdd.racingcar;

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

		while (tryCount.isRemain()) {
			cars.move();
			record.add(OutputUtils.getState(cars));
			tryCount.consume();
		}

		OutputView.printResultMessage();
		record.forEach(OutputView::printRecord);
		OutputView.printWinners(OutputUtils.getWinners(cars));
	}
}
