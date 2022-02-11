package racingcar.controller;

import java.util.List;

import racingcar.domain.round.Round;
import racingcar.service.GameService;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class GameController {

	private final InputView inputView;
	private final OutputView outputView;
	private final GameService gameService;

	public GameController(GameService gameService, InputView inputView, OutputView outputView) {
		this.gameService = gameService;
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		initParticipants();
		playGame();
		announceWinners();
	}

	private void initParticipants() {
		gameService.initCarNames(requestCarNames());
	}

	private List<String> requestCarNames() {
		outputView.printMessageOfRequestCarNames();
		return inputView.requestCarNames();

	}

	private void playGame() {
		Round round = requestRound();
		announceStatusTitle();
		while (round.isNotFinished()) {
			List<String> carStatuses = gameService.playRound();
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
		List<String> winnerNames = gameService.getWinnerNames();
		outputView.printMessageOfWinners(winnerNames);
	}

}
