package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.view.OutputView;

public class GameController {
	private static final GameController gameController = new GameController();
	private static InputController inputController = InputController.getInputController();

	private GameController() {
	}

	public static GameController getGameController() {
		return gameController;
	}

	public void runGame() {
		final RacingCarGame racingCarGame = setUpGame();

		playGame(racingCarGame);

		finishGame(racingCarGame);
	}

	private RacingCarGame setUpGame() {
		OutputView.showCarNamesInputGuideMessage();
		List<String> carNames = inputController.inputCarName();

		OutputView.showRaceCountInputGuideMessage();
		int raceCount = inputController.inputRaceCount();

		return new RacingCarGame(carNames, raceCount);
	}

	private void playGame(final RacingCarGame racingCarGame) {
		OutputView.showRaceProgressGuideMessage();
		while (!racingCarGame.isOverRace()) {
			racingCarGame.startRace();
			OutputView.showRaceProgress(racingCarGame.sendCurrentLocationOfCars());
		}
	}

	private void finishGame(final RacingCarGame racingCarGame) {
		OutputView.showGameWinner(racingCarGame.findRacingGameWinner());
	}
}
