import racingcar.controller.RacingGame;
import racingcar.utils.InputValidation;
import racingcar.views.Input;
import racingcar.views.Output;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		final Input input = new Input(new InputValidation(), new Scanner(System.in));
		final RacingGame racingGame = new RacingGame(input, new Output());
		racingGame.startGame();
	}
}
