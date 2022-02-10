package racingcar.controller;

import java.io.IOException;

import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private Cars cars;
	private TryCount tryCount;

	public void start() {
		try {
			cars = new Cars(InputView.inputCarNames());
			inputTryCount();
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e);
			start();
		}
	}

	private void inputTryCount() {
		try {
			tryCount = new TryCount(InputView.inputTryCount());
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e);
			inputTryCount();
		}
	}
}
