package racingcar.controller;

import racingcar.models.RacingGame;
import racingcar.utils.RacingGameMessage;
import racingcar.views.Input;
import racingcar.views.Output;

public class Racing {
	private RacingGame racingGame;

	public void startRacing() {
		final String carNames = Input.inputValidNames();
		final int repeats = Input.inputValidRepeats();
		racingGame = new RacingGame(carNames, repeats,
			RacingGameMessage.CAR_NAME_DISTRIBUTOR);

		Output.printResultMessage();
		while (!racingGame.isEnd()) {
			racingGame.race();
			Output.printTurnResult(racingGame.getThisTurnResult());
		}
		Output.printWinner(racingGame.getWinnersName());
	}
}
