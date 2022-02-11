import java.util.Scanner;

import racingcar.controller.RacingGame;
import racingcar.utils.InputValidation;
import racingcar.views.Input;
import racingcar.views.Output;

public class Application {
	public static void main(String[] args) {
		Input input = new Input(new InputValidation(), new Scanner(System.in));
		RacingGame racingGame = new RacingGame(input, new Output());
		racingGame.startGame();
	}
}
