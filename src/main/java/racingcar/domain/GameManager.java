package racingcar.domain;

import racingcar.dto.GameResultDTO;
import racingcar.dto.RoundResultDTO;
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

	public void createCars() {
		inputView.inputCarName()
			.getCarNames()
			.forEach(cars::generateCar);
	}

	public void createGameRound() {
		int totalRound = inputView.inputGameRound().getRound();
		gameRound = new GameRound(totalRound);
	}

	public void playGame() {
		outputView.printResultMessage();
		while(!gameRound.isEnd()) {
			cars.moveCars();
			gameRound.increaseRound();
			RoundResultDTO roundResultDTO = new RoundResultDTO(cars.getCars());
			outputView.printRoundResult(roundResultDTO);
		}
	}

	private void createCars() {
		while(true) {
			try {
				CarNamesDTO carNamesDTO = inputView.inputCarName();
				List<String> carNames = carNamesDTO.getCarNames();
				cars.generateCars(carNames);
				return;
			} catch (Exception e) {
				outputView.printErrorMeesage(e.getMessage());
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
				outputView.printErrorMeesage(e.getMessage());
			}
		}
	}

	private void endGame() {
		GameResultDTO gameResultDTO = new GameResultDTO(cars.findWinnerNames());
		outputView.printEndGameResult(gameResultDTO);

	}
}
