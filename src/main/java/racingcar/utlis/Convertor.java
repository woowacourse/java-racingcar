package racingcar.utlis;

public class Convertor {
	private static final String SEPARATION_REGEX = ",";

	public static String[] separateNamesByDelimiter(String names) {
		return names.split(SEPARATION_REGEX);
	}

	public static int convertStringToInteger(String count) {
		return Integer.parseInt(count);
	}
}
