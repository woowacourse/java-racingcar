import domain.GameManager;
import view.InputView;
import view.OutputView;

public class Application {
	public static void main(String[] args) {
		String carsName = InputView.inputCarNames();
		String attemptNo = InputView.inputAttemptNumber();

		GameManager gameManager = createGameManager(carsName, attemptNo);
		while (!gameManager.isEnd()) {
			OutputView.printRacingResults(gameManager.race());
		}
		OutputView.printWinners(gameManager.findWinners());
	}

	private static GameManager createGameManager(String carNames, String attemptNo) {
		while (true) {
			try {
				return new GameManager(carNames, attemptNo);
			} catch (IllegalArgumentException e) {
				OutputView.printExceptionMsg(e.getMessage());
			}
		}
	}

}
