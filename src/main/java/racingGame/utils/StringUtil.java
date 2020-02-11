package racingGame.utils;

public class StringUtil {
	private static final String DELIMITER = ",";

	public static String[] splitCarName(final String inputCarName) {
		return inputCarName.split(DELIMITER);
	}
}
