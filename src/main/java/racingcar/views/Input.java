package racingcar.views;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import racingcar.utils.InputValidation;

public class Input {

	private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String INPUT_REPEATS = "시도할 회수는 몇회인가요?";
	private final static String CAR_NAME_DISTRIBUTOR = ",";

	final InputValidation inputValidation;
	final Scanner scanner;

	public Input(final InputValidation inputValidation, final Scanner scanner) {
		this.inputValidation = inputValidation;
		this.scanner = scanner;
	}

	public List<String> inputValidNames() {
		final String names = inputNames();
		return Arrays.stream(names.split(CAR_NAME_DISTRIBUTOR))
			.collect(Collectors.toList());
	}

	private String inputNames() {
		try {
			System.out.println(INPUT_CAR_NAME);
			final String names = scanner.next();
			inputValidation.validateName(names);
			return names;
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage() + System.lineSeparator());
			return inputNames();
		}
	}

	public int inputRepeats() {
		try {
			System.out.println(INPUT_REPEATS);
			final String repeats = scanner.next();
			int repeatsNumber = inputValidation.validateNotIntegerRepeats(repeats);
			inputValidation.validateNegativeNumberRepeats(repeatsNumber);
			return repeatsNumber;
		} catch (RuntimeException exception) {
			System.out.println(exception.getMessage() + System.lineSeparator());
			return inputRepeats();
		}
	}
}
