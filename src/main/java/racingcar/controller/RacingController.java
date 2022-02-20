package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.CarDtos;
import racingcar.model.Cars;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private static final Cars cars = new Cars();

	public static void main(String[] args) {
		RacingController controller = new RacingController();
		controller.createCarsByUserInput();

		List<CarDtos> gameResult = controller.runForIteration(InputView.getIterationNumber());
		ResultView.printGameResult(gameResult);
		ResultView.printWinners(controller.getWinners());
	}

	public void createCarsByUserInput() {
		try {
			createCars(InputView.getCarNames());
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			createCarsByUserInput();
		}
	}

	void createCars(String carNames) {
		cars.createCars(splitCarNames(carNames));
	}

	List<String> splitCarNames(String input) {
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private List<CarDtos> runForIteration(int iteration) {
		return IntStream.range(0, iteration)
			.mapToObj(i -> moveCars())
			.collect(Collectors.toList());
	}

	CarDtos moveCars() {
		int numberOfCars = cars.getSize();
		return new CarDtos(cars.moveAll(Random.createNumbers(numberOfCars)));
	}

	CarDtos getCars() {
		return new CarDtos(cars.getCars());
	}

	CarDtos getWinners() {
		return new CarDtos(cars.getWinners());
	}
}
