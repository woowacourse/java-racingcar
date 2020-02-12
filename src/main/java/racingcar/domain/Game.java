package racingcar.domain;

import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Game {
	public void run() {
		Cars cars = InputView.getCars();
		Times times = InputView.getTimes();
		OutputView.printResultTitle();
		cars.move(times);
		OutputView.printWinners(new Winners(cars.getWinners()));
	}
}
