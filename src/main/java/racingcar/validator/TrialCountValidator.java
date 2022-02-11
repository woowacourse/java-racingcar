package racingcar.validator;

public class TrialCountValidator {

	public static void checkTrialCountLine(String line) {
		trialCountNotNumericValueException(line);
		trialCountZeroException(line);
	}

	private static void trialCountNotNumericValueException(String line) {
		try {
			Integer.parseInt(line);
		} catch (NumberFormatException exception) {
			throw new RuntimeException("시도 횟수가 숫자가 아닙니다.");
		}
	}

	private static void trialCountZeroException(String line) {
		if (Integer.parseInt(line) <= 0) {
			throw new RuntimeException("시도 횟수가 음수나 0이 될 수 없습니다.");
		}
	}
}
