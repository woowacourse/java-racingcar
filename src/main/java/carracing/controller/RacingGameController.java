package carracing.controller;

import java.util.ArrayList;
import java.util.List;

import carracing.model.Car;
import carracing.model.Cars;
import carracing.view.input.InputView;
import carracing.view.output.OutputView;

public class RacingGameController {
	private static final int END_OF_GAME_COUNT = 0;

	private InputView inputView;
	private OutputView outputView;
	private Cars cars;
	private int numberOfGames;

	public RacingGameController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void init() {
		getCars();
		getNumberOfGames();
	}

	public void play() {
		outputView.printResultMessage();
		while (isContinue()) {
			cars.moveCars();
			outputView.printResultOfEachGame(cars.getCars());
		}
		endGame();
	}

	private boolean isContinue() {
		return (numberOfGames--) > END_OF_GAME_COUNT;
	}

	private void getCars() {
		outputView.printInputCarName();
		List<String> carNames = inputView.getCarNames();
		try {
			createCars(carNames);
		} catch (IllegalArgumentException e) {
			outputView.printException(e.getMessage());
			getCars();
		}
	}

	private void getNumberOfGames() {
		outputView.printInputNumberOfGames();
		try {
			numberOfGames = inputView.getNumberOfGames();
		} catch (IllegalArgumentException e) {
			outputView.printException(e.getMessage());
			getNumberOfGames();
		}
	}

	private void endGame() {
		outputView.printWinners(cars.getWinners());
	}

	private void createCars(List<String> carNames) {
		List<Car> carList = new ArrayList<>();
		for (String carName : carNames) {
			carList.add(Car.from(carName));
		}
		cars = new Cars(carList);
	}
}
