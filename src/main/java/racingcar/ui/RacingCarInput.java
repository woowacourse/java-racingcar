package racingcar.ui;

import static racingcar.RacingCarMain.*;

import java.util.List;

import racingcar.domain.Car;
import racingcar.utils.CarsGenerator;
import racingcar.validator.RoundNumberValidator;

public class RacingCarInput {
	private static final String CAR_NAME_INPUT_MESSAGE
		= "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ROUND_INPUT_MESSAGE
		= "시도할 회수는 몇회인가요?";

	public static List<Car> carNameInput() {
		String userInput = userCarNameInput();
		try {
			return CarsGenerator.generateCars(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return carNameInput();
		}
	}

	private static String userCarNameInput() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);
		return sc.nextLine();
	}

	public static int roundInput() {
		String roundNumberString = userRoundInput();
		try {
			return toIntWithValidate(roundNumberString);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return roundInput();
		}
	}

	private static int toIntWithValidate(String roundNumberString) {
		RoundNumberValidator.validate(roundNumberString);
		return Integer.parseInt(roundNumberString);
	}

	private static String userRoundInput() {
		System.out.println(ROUND_INPUT_MESSAGE);
		return sc.nextLine();
	}
}
