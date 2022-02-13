package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racingcar.util.Converter;
import racingcar.validator.InputValidator;

public class InputView {

	private static final String CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";
	private static final String SEPARATOR_OF_CAR_NAME = ",";

	private static final Scanner scanner = new Scanner(System.in);

	public static List<String> getCarNames() {
		System.out.println(CAR_NAMES_MESSAGE);
		String input = scanner.nextLine();
		InputValidator.ofCarNamesInput(input);

		return Arrays.stream(input.split(SEPARATOR_OF_CAR_NAME))
			.collect(Collectors.toList());
	}

	public static int getAttemptNumber() {
		System.out.println(ATTEMPT_NUMBER_MESSAGE);
		return Converter.toAttemptNumber(scanner.next());
	}
}