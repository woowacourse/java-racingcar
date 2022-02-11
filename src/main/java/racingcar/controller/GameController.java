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
		initGame();
		playGame();
		announceWinners();
	}

	private void initGame() {
		initParticipants();
		initRound();
	}

	private void initParticipants() {
		gameService.initCarNames(requestCarNames());
	}

	private List<String> requestCarNames() {
		outputView.printMessageOfRequestCarNames();
		return inputView.requestCarNames();
	}

	private void initRound() {
		gameService.initRound(requestRound());
	}

	private int requestRound() {
		outputView.printMessageOfRequestRound();
		return inputView.requestRoundNumber();
	}

	private void playGame() {
		announceStatusTitle();
		while (gameService.isContinuable()) {
			List<String> carStatuses = gameService.playRound();
			announceStatuses(carStatuses);
		}
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
