import controller.RacingGame;
import domain.strategy.MovingStrategy;
import domain.strategy.RandomNumberMovingStrategy;
import view.InputView;
import view.OutputView;

public class Application {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		MovingStrategy movingStrategy = new RandomNumberMovingStrategy();

		RacingGame racingGame = new RacingGame(inputView, outputView, movingStrategy);
		racingGame.run();
	}
}
