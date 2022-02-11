package racingCar.utlis;

public class Convertor {

	public static String[] separate(String text) {
		return text.split(Constants.NAME_REGEX);
	}

	public static int convertToInteger(String count) {
		return Integer.parseInt(count);
	}
}
