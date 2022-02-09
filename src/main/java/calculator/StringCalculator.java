package calculator;

public class StringCalculator {

	public int calculate(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		return Integer.parseInt(text);
	}
}
