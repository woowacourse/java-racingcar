package racingcar.controller;

import static racingcar.model.CarToCarDtoMapper.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.CarDto;
import racingcar.model.CarToCarDtoMapper;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingController {
	public static void runGame() {
		RacingController controller = new RacingController();
		controller.createCarsByUserInput();

		int iteration = InputView.getIterationNumber();
		List<List<CarDto>> gameResult = controller.runForIteration(iteration);
		ResultView.printGameResult(gameResult);

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

	private List<List<CarDto>> runForIteration(int iteration) {
		return CarToCarDtoMapper.ToCarDtoGroups(Racing.runForIteration(iteration));
	}

	private List<CarDto> getWinners() {
		return ToCarDtos(Racing.getWinners());
	}
}
