
import racingcar.controller.RacingGame;
import racingcar.views.Output;

public class Application {

	public static void main(String[] args) {
		final RacingGame racingGame = new RacingGame(new Output());
		racingGame.startGame();
	}
}
