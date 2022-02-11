package carracing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import carracing.model.Car;
import carracing.model.Cars;
import carracing.view.InputView;
import carracing.view.OutputView;

public class RacingGameController {
	public static final int ZERO = 0;
	public static final String DELIMITER_REGEX = ",";
	public static final String DELIMITER_JOIN = ",";

	private Cars cars;
	private int numberOfGames;

	public RacingGameController() {
	}

	public void init(){
		getCars();
		getNumberOfGames();
	}

	public void play() {
		OutputView.printResultMessage();
		while((numberOfGames--) > ZERO){
			cars.moveCars();
			cars.printResult();
		}
		endGame();
	}

	private void endGame() {
		OutputView.printWinners(String.join(DELIMITER_JOIN, cars.getWinners()));
	}

	private void getNumberOfGames() {
		OutputView.printInputNumberOfGames();
		try{
			numberOfGames = InputView.getNumberOfGames();
		}catch (IllegalArgumentException e){
			OutputView.printException(e.getMessage());
			getNumberOfGames();
		}
	}

	private void getCars() {
		OutputView.printInputCarName();
		try {
			String readLine = InputView.getCarNames();
			List<String> carNames = splitCarNames(readLine);
			createCars(carNames);
		} catch (IllegalArgumentException e){
			OutputView.printException(e.getMessage());
			getCars();
		}
	}

	private List<String> splitCarNames(String readLine) {
		return Arrays.asList(readLine.split(DELIMITER_REGEX));
	}

	private void createCars(List<String> carNames) {
		List<Car> carList = new ArrayList<>();
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
		cars = new Cars(carList);
	}
}
