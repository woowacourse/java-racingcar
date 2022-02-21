package racingcar.controller;

import static racingcar.model.DtoMapper.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.CarDto;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	public static void runGame() {
		RacingController controller = new RacingController();
		controller.createCarsByUserInput();

		int iteration = InputView.getIterationNumber();
		List<GameResult> gameResults = controller.runForIteration(iteration);
		ResultView.printGameResult(gameResults);

		ResultView.printWinners(controller.getWinners());
	}

	private void createCarsByUserInput() {
		try {
			Racing.createCars(splitCarNames(InputView.getCarNames()));
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			createCarsByUserInput();
		}
	}

	private List<String> splitCarNames(String input) {
		return Arrays.stream(input.split(","))
			.map(String::trim)
			.collect(Collectors.toList());
	}

	private List<GameResult> runForIteration(int iteration) {
		return ToGameResults(Racing.runForIteration(iteration));
	}

	private List<CarDto> getWinners() {
		return ToCarDtos(Racing.getWinners());
	}
}
