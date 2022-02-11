package racingcar.controller;

import racingcar.domain.car.Cars;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		String carNames = inputView.inputCarNames();
		String roundNumber = inputView.inputRoundNumber();

		RacingCarService service = new RacingCarService(carNames, roundNumber);
		while (!service.isEnd()) {
			Cars result = service.run();
			outputView.printCarsPosition(result);
		}
		outputView.printWinners(service.getWinners());
	}
}
