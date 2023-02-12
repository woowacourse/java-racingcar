package racingcar.controller;

import racingcar.domain.game.GameManager;
import racingcar.dto.CarNamesRequest;
import racingcar.dto.GameTotalRoundRequest;
import racingcar.dto.GameWinnersResponse;
import racingcar.dto.RoundResultResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
	private final InputView inputView;
	private final OutputView outputView;
	private final GameManager gameManager;

	public GameController(InputView inputView, OutputView outputView, GameManager gameManager) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.gameManager = gameManager;
	}

	public void playGame() {
		createCars();
		createGameRound();
		startRace();
		endRace();
	}

	private void createCars() {
		while (true) {
			try {
				final CarNamesRequest request = inputView.getCarNames();
				gameManager.setUpCars(request.getCarNames());

				return;
			} catch (Exception e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void createGameRound() {
		while (true) {
			try {
				final GameTotalRoundRequest request = inputView.getTotalGameRound();
				gameManager.setUpGameRound(request.getGameTotalRound());

				return;
			} catch (Exception e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void startRace() {
		outputView.printResultMessage();
		while (gameManager.isGameContinue()) {
			RoundResultResponse response = gameManager.moveCars();
			outputView.printRoundResult(response);
		}
	}

	private void endRace() {
		GameWinnersResponse response = gameManager.getGameResult();
		outputView.printEndGameResult(response);
	}
}
