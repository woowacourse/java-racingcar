package racingcar.controller;

import static racingcar.model.CarToCarDtoMapper.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.CarDto;
import racingcar.model.Cars;
import racingcar.model.Random;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	private static final Cars cars = new Cars();

	public static void main(String[] args) {
		RacingController controller = new RacingController();
		controller.createCarsByUserInput();

		List<List<CarDto>> gameResult = controller.runForIteration(InputView.getIterationNumber());
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

	private List<List<CarDto>> runForIteration(int iteration) {
		return IntStream.range(0, iteration)
			.mapToObj(i -> moveCars())
			.collect(Collectors.toList());
	}

	List<CarDto> moveCars() {
		int numberOfCars = cars.getSize();
		return carsToCarDtos(cars.moveAll(Random.createNumbers(numberOfCars)));
	}

	List<CarDto> getCars() {
		return carsToCarDtos(cars.getCars());
	}

	List<CarDto> getWinners() {
		return carsToCarDtos(cars.getWinners());
	}
}
