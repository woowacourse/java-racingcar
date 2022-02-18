package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

	public void run() {
		String[] carNames = InputView.getCarNames();
		String tryNo = InputView.getCount();

		Racing racing = new Racing(carNames, tryNo);
		OutPutView.printStatusMessage();
		while (!racing.isEnd()) {
			OutPutView.printStatus(racing.race());
		}

		OutPutView.printResult(racing.getWinners());
	}
}
