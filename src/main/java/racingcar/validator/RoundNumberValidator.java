package racingcar.validator;

public class RoundNumberValidator {

	public static void validate(String round) {
		if (!isPositiveNumber(round)) {
			throw new IllegalArgumentException("자연수로 입력해 주세요.");
		}
	}

	private static boolean isPositiveNumber(String round) {
		return round.matches("^([1-9][0-9]*)$");
	}
}
