package racingcar.validator;

public class GameCountValidator {
	public static void checkAccuracyOfGameCount(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("게임 횟수는 정수를 입력해주세요.");
		}
	}
}
