package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Count;
import racingcar.domain.Racing;
import racingcar.validator.RacingCarValidator;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

	public void run() {
		String[] carNames = InputView.getCarNames();
		/*RacingCarValidator.validateCars(cars);*/
		String tryNo = InputView.getCount();

		Racing racing = new Racing(carNames, tryNo);
		OutPutView.printStatusMessage();
		while (!racing.isEnd()) {
			OutPutView.printStatus(racing.race());
		}

		OutPutView.printResult(racing.getWinners());
	}
}
