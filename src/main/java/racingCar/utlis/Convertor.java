package racingCar.utlis;

public class Convertor {

	public static final String NAME_REGEX = ",";

	public static String[] separate(String text) {
		return text.split(NAME_REGEX);
	}

	public static int convertToInteger(String count) {
		return Integer.parseInt(count);
	}
}
