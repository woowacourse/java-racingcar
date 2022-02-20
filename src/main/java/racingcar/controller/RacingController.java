package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.CarDto;
import racingcar.model.CarToCarDtoMapper;
import racingcar.model.Cars;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private static final Cars cars = new Cars();

	public static void main(String[] args) {
		RacingController controller = new RacingController();
		controller.createCarsByUserInput();
		controller.runInIteration(InputView.getIterationNumber());
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

	List<String> splitCarNames(String input) {
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	void createCars(String carNames) {
		cars.createCars(splitCarNames(carNames));
	}

	private void runInIteration(int iteration) {
		for (int i = 0; i < iteration; i++) {
			moveAll();
			ResultView.printGameResult(getCars());
		}
	}

	void moveAll() {
		int numberOfCars = cars.getSize();
		cars.moveAll(new Random().createNumbers(numberOfCars));
	}

	List<CarDto> getCars() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getCars());
	}

	List<CarDto> getWinners() {
		return CarToCarDtoMapper.carsToCarDtos(cars.getWinners());
	}
}
