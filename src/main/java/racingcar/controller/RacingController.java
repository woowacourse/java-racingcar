package racingcar.controller;

import java.io.IOException;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private Cars cars;

	public void start() {
		try {
			cars = new Cars(InputView.inputCarNames());
		} catch (IllegalArgumentException | IOException e) {
			OutputView.printException(e);
			start();
		}
	}
}
