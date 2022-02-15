package racingcar.controller;

import racingcar.domain.Racing;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

	public void run() {
		Racing racing = new Racing(InputView.getCars(), InputView.getCount());

		OutPutView.printStatusMessage();
		while (racing.isEnd()) {
			OutPutView.printStatus(racing.race());
		}

		OutPutView.printResult(racing.getWinners());
	}
}
