package racingcar.controller;

import java.util.List;

import racingcar.controller.picker.NumberPicker;
import racingcar.domain.car.CarCollection;
import racingcar.domain.round.Round;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

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
		CarCollection carCollection = initCarCollection();
		Round round = initRound();
		playGame(carCollection, round);
		announceWinners(carCollection);
	}

	private CarCollection initCarCollection() {
		outputView.printMessageOfRequestCarNames();
		return new CarCollection(inputView.requestCarNames());
	}

	private Round initRound() {
		outputView.printMessageOfRequestRound();
		return new Round(inputView.requestRoundNumber());
	}

	private void playGame(CarCollection carCollection, Round round) {
		outputView.printEmptyLine();
		outputView.printMessageTitleOfStatus();
		while (!round.isFinish()) {
			carCollection.play(numberPicker);
			List<String> carStatuses = carCollection.getStatuses();
			outputView.printCarStatuses(carStatuses);
			round.decreaseCount();
			outputView.printEmptyLine();
		}
	}

	private void announceWinners(CarCollection carCollection) {
		List<String> winnerNames = carCollection.getWinnerNames();
		outputView.printMessageOfWinners(winnerNames);
	}

}
