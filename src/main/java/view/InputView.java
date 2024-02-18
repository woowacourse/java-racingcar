package view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

import constants.ErrorMessages;

public class InputView {
	private final Scanner scanner = new Scanner(System.in);

	private <T> T retryInputOnException(Supplier<T> supplier) {
		try {
			return supplier.get();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return retryInputOnException(supplier);
		}
	}


	public String receiveNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String names = scanner.nextLine();
		validateCarNames(names);
		return names;
	}

	private void validateCarNames(String names) {
		final String VALID_CAR_NAMES_REGEX = "(.+)((,)(.+))*";
		if (isInvalidFormat(names, VALID_CAR_NAMES_REGEX)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
		}
		if (hasInvalidNameLength(names.split(","))) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
		}
	}

	private boolean hasInvalidNameLength(String[] names) {
		return Arrays.stream(names)
			.anyMatch(name -> name.isBlank() || name.length() > 5);
	}

	public int receiveTrialCount() {
		System.out.println("시도할 회수는 몇회인가요?");
		String trial = scanner.nextLine();

		validateTrialCount(trial);
		return Integer.parseInt(trial);
	}

	private void validateTrialCount(String trialCount) {
		final String COUNT_FORMAT = "[0-9]+";
		if (isInvalidFormat(trialCount, COUNT_FORMAT)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT.getMessage());
		}
	}

	private boolean isInvalidFormat(String input, String regex) {
		return !input.matches(regex);
	}

}
