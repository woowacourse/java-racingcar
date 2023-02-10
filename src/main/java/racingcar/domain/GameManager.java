package racingcar.domain;

import java.util.List;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.GameResultResponse;
import racingcar.dto.RoundResultResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameManager {

	private final InputView inputView;
	private final OutputView outputView;
	private final CarMovement carMovement;
	private GameRound gameRound;
	private final Cars cars;

	public GameManager(
		final InputView inputView,
		final OutputView outputView,
		final CarMovement carMovement,
		final Cars cars
	) {
		this.inputView = inputView;
		this.outputView = outputView;
		this.carMovement = carMovement;
		this.cars = cars;
	}

	public void playGame() {
		createCars();
		createGameRound();
		startEachGameRound();
		endGame();
	}

	private void startEachGameRound() {
		outputView.printResultMessage();
		while (!gameRound.isEnd()) {
			cars.moveCars();
			gameRound.increaseRound();
			final RoundResultResponse roundResultResponse = RoundResultResponse.from(cars.getCars());
			outputView.printRoundResult(roundResultResponse);
		}
	}

	private void createCars() {
		while (true) {
			try {
				final CarNamesRequest carNamesRequest = inputView.inputCarNames();
				final List<String> carNames = carNamesRequest.getCarNames();
				cars.generateCars(carMovement, carNames);
				return;
			} catch (Exception e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void createGameRound() {
		while (true) {
			try {
				final int totalRound = inputView.inputGameRound().getRound();
				gameRound = new GameRound(totalRound);
				return;
			} catch (Exception e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void endGame() {
		final GameResultResponse gameResultResponse = GameResultResponse.from(cars.findWinnerNames());
		outputView.printEndGameResult(gameResultResponse);
	}
}
