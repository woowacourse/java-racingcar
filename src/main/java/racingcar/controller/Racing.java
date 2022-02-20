package racingcar.controller;

import java.util.List;

import racingcar.models.RacingGame;
import racingcar.views.Input;
import racingcar.views.Output;

public class Racing {
	private RacingGame racingGame;

	public void startRacing() {
		final List<String> carNames = Input.inputValidNames();
		final int repeats = Input.inputValidRepeats();
		racingGame = new RacingGame(carNames, repeats);

		Output.printResultMessage();
		while (!racingGame.isEnd()) {
			racingGame.race();
			Output.printTurnResult(racingGame.getThisTurnResult());
		}
		Output.printWinner(racingGame.getWinnersName());
	}
}
