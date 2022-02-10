package carracing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import carracing.Car;
import carracing.Cars;
import carracing.view.InputView;
import carracing.view.OutputView;

public class RacingGameController {
	private Cars cars;
	private int numberOfGames;

	public RacingGameController() {
	}

	public void init(){
		OutputView.printInputCarName();
		getCars();
		OutputView.printInputNumberOfGames();
		getNumberOfGames();
	}

	public void play() {
		OutputView.printResultMessage();
		while((numberOfGames--) > 0){
			cars.moveCars();
			cars.printResult();
		}
	}

	private void getNumberOfGames() {
		try{
			numberOfGames = InputView.getNumberOfGames();
		}catch (IllegalArgumentException e){
			OutputView.printException(e.getMessage());
			getNumberOfGames();
		}
	}

	private void getCars() {
		try {
			String readLine = InputView.getCarNames();
			List<String> carNames = Arrays.asList(readLine.split(","));
			createCars(carNames);
		} catch (IllegalArgumentException e){
			OutputView.printException(e.getMessage());
			getCars();
		}
	}

	private void createCars(List<String> carNames) {
		List<Car> carList = new ArrayList<>();
		for (String carName : carNames) {
			carList.add(new Car(carName));
		}
		cars = new Cars(carList);
	}
}
