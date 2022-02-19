package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racingcar.domain.CarDto;
import racingcar.util.validator.InputValidator;

public class InputView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String SEPARATOR_OF_CAR_NAME = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static List<CarDto> getCars() {
		System.out.println(CAR_NAMES_MESSAGE);
		String input = scanner.nextLine();
		InputValidator.checkCarNames(input);

		return Arrays.stream(input.split(SEPARATOR_OF_CAR_NAME))
			.map(CarDto::of)
			.collect(Collectors.toList());
	}

	public static String getAttemptNumber() {
		System.out.println(ATTEMPT_NUMBER_MESSAGE);
		String input = scanner.nextLine();
		InputValidator.checkAttemptNumber(input);

		return input;
	}
}