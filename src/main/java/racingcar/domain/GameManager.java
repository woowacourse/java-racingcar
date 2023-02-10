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
		InputView inputView,
		OutputView outputView,
		CarMovement carMovement,
		Cars cars
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
			RoundResultResponse roundResultResponse = RoundResultResponse.from(cars.getCars());
			outputView.printRoundResult(roundResultResponse);
		}
	}

	private void createCars() {
		while (true) {
			try {
				CarNamesRequest carNamesRequest = inputView.inputCarNames();
				List<String> carNames = carNamesRequest.getCarNames();
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
				int totalRound = inputView.inputGameRound().getRound();
				gameRound = new GameRound(totalRound);
				return;
			} catch (Exception e) {
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void endGame() {
		GameResultResponse gameResultResponse = GameResultResponse.from(cars.findWinnerNames());
		outputView.printEndGameResult(gameResultResponse);
	}
}
