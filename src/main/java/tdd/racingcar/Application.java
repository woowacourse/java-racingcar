package tdd.racingcar;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import tdd.racingcar.domain.Cars;
import tdd.racingcar.domain.CarsFactory;
import tdd.racingcar.domain.TryCount;
import tdd.racingcar.view.InputView;
import tdd.racingcar.view.OutputView;

public class Application {
	public static void main(final String[] args) {
		final Cars cars = CarsFactory.create(InputView.inputNames());
		final TryCount tryCount = new TryCount(InputView.inputTryCount());
		final Queue<Map<String, Integer>> record = new LinkedList<>(); // refactoring 필요
		OutputView.printResultMessage();
		tryCount.forEachRemaining(count -> {
			cars.move();
			record.add(cars.getPositions());
		});
		OutputView.printRecord(record);
		OutputView.printWinners(cars.getWinners());
	}
}
