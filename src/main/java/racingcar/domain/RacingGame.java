package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.utils.RandomNumber;
import racingcar.utils.Split;
import racingcar.utils.Validator;
import racingcar.utils.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
	private static List<Car> racingCarList;

	public static void runRacingGame() {
		try {
			String[] carNames = getRacingCarNames();
			int playRound = getRacingRound();

			racingCarList = new ArrayList<>(carNames.length);
			for (String carName : carNames) {
				racingCarList.add(new Car(carName));
			}

			for (int i = 0; i < playRound; i++) {
				for (Car car : racingCarList) {
					car.move(RandomNumber.generateRandomIntIntRange());
					OutputView.printRoundResult(car);
				}
				System.out.println();
			}

			OutputView.printWinners(Winner.getWinners(racingCarList));

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			runRacingGame();
		}
	}

	private static String[] getRacingCarNames() {
		try {
			String input = InputView.getCarNames();
			String[] carNames = Split.splitInputName(input);
			Validator.validateCarNames(carNames);
			return carNames;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getRacingCarNames();
		}
	}

	private static int getRacingRound() {
		try {
			String playRound = InputView.getPlayRound();
			Validator.validatePlayRound(playRound);
			return Integer.parseInt(playRound);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getRacingRound();
		}
	}

}
