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
	private final Cars cars;
	private GameRound gameRound;

	public GameManager(InputView inputView, OutputView outputView, Cars cars) {
		this.inputView = inputView;
		this.outputView = outputView;
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
			RoundResultResponse carsRoundResult = new RoundResultResponse(cars.getCars());
			outputView.printRoundResult(carsRoundResult);
		}
	}

	private void createCars() {
		while (true) {
			try {
				CarNamesRequest requestCarNames = inputView.inputCarName();
				List<String> carNames = requestCarNames.getCarNames();
				cars.generateCars(carNames);
				return;
			} catch (Exception e) {
				cars.reset();
				outputView.printErrorMessage(e.getMessage());
			}
		}
	}

	private void createGameRound() {
		while(true) {
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
		GameResultResponse gameResult = new GameResultResponse(cars.findWinnerNames());
		outputView.printEndGameResult(gameResult);
	}
}
