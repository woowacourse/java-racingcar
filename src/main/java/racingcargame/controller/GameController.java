package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.view.Display;

public class GameController {
	private static final GameController gameController = new GameController();
	private static final InputController inputController = InputController.getInputController();

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
		Display.showRacingCarNamesInputGuideMessage();
		List<String> racingCarNames = inputController.inputRacingCarNames();

		Display.showRaceCountInputGuideMessage();
		int raceCount = inputController.inputRaceCount();

		return new RacingCarGame(racingCarNames, raceCount);
	}

	private void playGame(final RacingCarGame racingCarGame) {
		Display.showRaceProgressGuideMessage();
		while (!racingCarGame.isOverRace()) {
			racingCarGame.startRace();
			Display.showRaceProgress(racingCarGame.sendCurrentPositionOfRacingCars());
		}
	}

	private void finishGame(final RacingCarGame racingCarGame) {
		Display.showGameWinner(racingCarGame.sendRacingGameWinner());
	}
}
