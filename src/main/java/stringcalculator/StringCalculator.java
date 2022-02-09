package stringcalculator;

public class StringCalculator {
	public StringCalculator() {
	}

	public int sum(String text) {
		if (text.isEmpty()) {
			throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
		}
		return 0;
	}

	public String[] split(String text) {
		return text.split(",|:");
	}

	public boolean isNumber(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int toNumber(String text) {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자를 입력 하셔야합니다.");
		}
	}

	public boolean isNegative(int number) {
		return number < 0;
	}
}
