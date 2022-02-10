package racingCar.controller;

import static racingCar.constants.RacingCarConstants.*;

import java.util.ArrayList;
import java.util.List;

import racingCar.domain.Car;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class RacingCarController {
	private ArrayList<Car> cars = new ArrayList<>();
	private int maxPosition = Integer.MIN_VALUE;
	private int times;

	public void start() {
		List<Car> winners;
		String[] carNames = getAndSeparateCarNames();
		racingCarTimes();
		makeCars(carNames);
		race(times);
		winners = findWinner(cars);
		OutputView.printWinners(winners);
	}

	private String[] getAndSeparateCarNames() {
		String inputCarName = InputView.userStringInput(INPUT_CAR_NAME_MESSAGE);
		return separateCarNames(inputCarName);
	}

	public String[] separateCarNames(String input) {
		String[] carNames = input.split(",");
		for (int idx = 0; idx < carNames.length; idx++) {
			carNames[idx] = carNames[idx].trim();
			checkCarName(carNames[idx]);
		}
		return carNames;
	}

	private void checkCarName(String name) {
		try {
			isRightLength(name);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			getAndSeparateCarNames();
		}
	}

	public void isRightLength(String name) throws RuntimeException {
		if (name.length() == 0 || name.length() > 5) {
			throw new RuntimeException();
		}
	}

	private void racingCarTimes() {
		String inputRacingTimes = InputView.userStringInput(INPUT_COUNT_MESSAGE);
		enterTimes(inputRacingTimes);
	}

	public void enterTimes(String input) {
		try {
			isRightTimes(input);
			times = Integer.parseInt(input);
		} catch (RuntimeException e) {
			OutputView.printError(e.getMessage());
			racingCarTimes();
		}
	}

	public void isRightTimes(String input) throws RuntimeException {
		final String REGEX = "[0-9]+";
		if (!input.matches(REGEX)) {
			throw new RuntimeException();
		}
	}

	private void makeCars(String[] carNames) {
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	private void race(int count) {
		OutputView.startPrintResultMessage();
		for (int i = 0; i < count; i++) {
			moveCars();
			OutputView.printCars(cars);
		}
	}

	private void moveCars() {
		for (int idx = 0; idx < cars.size(); idx++) {
			moveCar(idx);
		}
	}

	private void moveCar(int idx) {
		Car car = cars.get(idx);
		car.moveCar(makeRandom());
	}

	private boolean makeRandom() {
		return ((int)(Math.random() * 10) - 1) >= 4;
	}

	public List<Car> findWinner(List<Car> cars) {
		List<Car> winners = new ArrayList<>();
		for (Car car : cars) {
			winners = checkLead(car, winners);
		}
		return winners;
	}

	private List<Car> checkLead(Car car, List<Car> winners) {
		if (car.getPosition() > maxPosition) {
			winners.clear();
			winners.add(car);
			maxPosition = car.getPosition();
			return winners;
		}
		if (car.getPosition() == maxPosition) {
			winners.add(car);
		}
		return winners;
	}
}
