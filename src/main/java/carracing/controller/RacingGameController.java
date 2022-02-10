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

	public RacingGameController() {
	}

	public void play() {
		OutputView.printInputCarName();
		try {
			String readLine = InputView.readLine();
			validateEmptyString(readLine);
			List<String> carNames = Arrays.asList(readLine.split(","));
			createCars(carNames);
		} catch (IllegalArgumentException e){
			play();
		}
	}

	private void validateEmptyString(String readLine) {
		if (readLine.isEmpty()) {
			throw new IllegalArgumentException("차 이름을 하나 이상 입력해야합니다.");
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
