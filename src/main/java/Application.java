
import racingcar.controller.RacingGame;
import racingcar.views.Input;

public class Application {

	public static void main(String[] args) {
		final String carNames = Input.inputValidNames();
		final int repeats = Input.inputValidRepeats();
		final RacingGame racingGame = new RacingGame(carNames, repeats);
		racingGame.startGame();
	}
}
