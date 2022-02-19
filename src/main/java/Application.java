
import racingcar.controller.RacingGame;
import racingcar.views.Input;
import racingcar.views.Output;

public class Application {

	public static void main(String[] args) {
		final String carNames = Input.inputValidNames();
		final int repeats = Input.inputValidRepeats();

		final RacingGame racingGame = new RacingGame(carNames, repeats);
		Output.printResultMessage();
		while (!racingGame.isEnd()) {
			racingGame.race();
			Output.printTurnResult(racingGame.getThisTurnResult());
			racingGame.endThisTurn();
		}
		Output.printWinner(racingGame.getWinnersName());
	}
}
