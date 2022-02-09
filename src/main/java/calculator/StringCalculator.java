package calculator;

public class StringCalculator {

	public int calculate(String text) {
		if (text == null || text.isEmpty()) {
			return 0;
		}

		String[] values = text.split(",");
		int total = 0;
		for (String value : values) {
			total += Integer.parseInt(value);
		}
		return total;
	}
}
