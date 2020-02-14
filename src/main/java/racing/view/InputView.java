package racing.view;

import static racing.domain.Car.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InputView {
	private static final String CAR_NAME_DELIMITER = ",";
	private static final String WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다.";

	public static Scanner input = new Scanner(System.in);

	public static List<String> inputCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		String carNames = input.nextLine();

		return Optional.ofNullable(carNames)
			.filter(InputView::checkNotNull)
			.map(InputView::splitAsComma)
			.filter(InputView::checkNotEmpty)
			.filter(InputView::checkLength)
			.orElseThrow(() -> new InputMismatchException(WRONG_INPUT_MESSAGE));
	}

	public static int inputRoundNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String round = input.nextLine();

		return Optional.ofNullable(round)
			.filter(InputView::checkNotNull)
			.filter(InputView::checkNumber)
			.map(Integer::parseInt)
			.orElseThrow(() -> new InputMismatchException(WRONG_INPUT_MESSAGE));
	}

	public static boolean checkNumber(String input) {
		return input.chars()
			.mapToObj(x -> (char)x)
			.allMatch(Character::isDigit);
	}

	public static List<String> splitAsComma(String value) {
		return Arrays.asList(value.split(CAR_NAME_DELIMITER, -1));
	}

	public static boolean checkNotEmpty(List<String> inputs) {
		return Optional.ofNullable(inputs)
			.filter(input -> !input.isEmpty())
			.isPresent();
	}

	public static boolean checkLength(List<String> input) {
		return input.stream().allMatch(InputView::isRightLength);
	}

	private static boolean isRightLength(String input) {
		return input.length() >= MIN_LENGTH && input.length() <= MAX_LENGTH;
	}

	public static boolean checkNotNull(String input) {
		return input != null;
	}
}