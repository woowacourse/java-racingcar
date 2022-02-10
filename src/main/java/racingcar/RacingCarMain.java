package racingcar;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.ui.RacingCarInput;
import racingcar.ui.RacingCarOutput;

public class RacingCarMain {
	public static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Car> cars = RacingCarInput.carNameInput();
		int round = RacingCarInput.roundInput();
		RacingService racingService = new RacingService(cars);
		RacingCarOutput.printRoundResultMessage();
		racingService.race(round);
		RacingCarOutput.printWinners(racingService.findWinners());
	}
}
