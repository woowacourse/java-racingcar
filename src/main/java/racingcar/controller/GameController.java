package racingcar.controller;

import java.util.List;

import racingcar.domain.round.Round;
import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;
	private final GameService racingCarService;

	public GameController(GameService racingCarService, InputView inputView, OutputView outputView) {
		this.racingCarService = racingCarService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		initParticipants();
		playGame();
		announceWinners();
	}

	private void initParticipants() {
		racingCarService.initCarNames(requestCarNames());
	}

	private List<String> requestCarNames() {
		outputView.printMessageOfRequestCarNames();
		return inputView.requestCarNames();

	}

	private void playGame() {
		Round round = requestRound();
		announceStatusTitle();
		while (round.isNotFinished()) {
			List<String> carStatuses = racingCarService.playRound();
			announceStatuses(carStatuses);
			round.decreaseCount();
		}
	}

	private Round requestRound() {
		outputView.printMessageOfRequestRound();
		return new Round(inputView.requestRoundNumber());
	}

	private void announceStatusTitle() {
		outputView.printEmptyLine();
		outputView.printMessageOfStatusTitle();
	}

	private void announceStatuses(List<String> carStatuses) {
		outputView.printCarStatuses(carStatuses);
		outputView.printEmptyLine();
	}

	private void announceWinners() {
		List<String> winnerNames = racingCarService.getWinnerNames();
		outputView.printMessageOfWinners(winnerNames);
	}

}
