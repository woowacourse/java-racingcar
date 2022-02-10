package racingcar.controller;

import java.util.List;

import racingcar.domain.CarCollection;
import racingcar.domain.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

	private final NumberPicker numberPicker;
	private final InputView inputView;
	private final OutputView outputView;

	public RacingCarController(NumberPicker numberPicker, InputView inputView, OutputView outputView) {
		this.numberPicker = numberPicker;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		outputView.printMessageOfRequestCarNames();
		CarCollection carCollection = new CarCollection(inputView.requestCarNames());

		outputView.printMessageOfRequestRound();
		Round round = new Round(inputView.requestGameRound());
		outputView.printEmptyLine();
		outputView.printMessageTitleOfStatus();

		while (!round.isFinish()) {
			carCollection.play(numberPicker);
			List<String> carStatuses = carCollection.getStatuses();
			outputView.printCarStatuses(carStatuses);
			round.decreaseCount();
			outputView.printEmptyLine();
		}

		List<String> winnerNames = carCollection.getWinnerNames();
		outputView.printMessageOfWinners(winnerNames);
	}


}
