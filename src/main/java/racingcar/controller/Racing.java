package racingcar.controller;

import racingcar.models.RacingGame;
import racingcar.views.Input;
import racingcar.views.Output;

public class Racing {
	private RacingGame racingGame;

	public void startRacing() {
		final String carNames = Input.inputValidNames();
		final int repeats = Input.inputValidRepeats();
		racingGame = new RacingGame(carNames, repeats);

		Output.printResultMessage();
		while (!racingGame.isEnd()) {
			racingGame.race();
			Output.printTurnResult(racingGame.getThisTurnResult());
			racingGame.endThisTurn();
		}
		Output.printWinner(racingGame.getWinnersName());
	}
}
