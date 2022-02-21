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

		int iteration = InputView.getIterationNumber();
		List<GameResult> gameResult = controller.runForIteration(iteration);
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

	private List<GameResult> runForIteration(int iteration) {
		return IntStream.range(0, iteration)
			.mapToObj(i -> moveCars())
			.collect(Collectors.toList());
	}

	GameResult moveCars() {
		int numberOfCars = cars.getSize();
		return new GameResult(ToCarDtos(cars.moveAll(Random.createNumbers(numberOfCars))));
	}

	GameResult getGameResult() {
		return new GameResult(ToCarDtos(cars.getCars()));
	}

	List<CarDto> getWinners() {
		return ToCarDtos(cars.getWinners());
	}
}
