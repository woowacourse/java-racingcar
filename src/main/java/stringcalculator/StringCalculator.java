package stringcalculator;

public class StringCalculator {

	public StringCalculator() {
	}

	public void validateInput(String text) {
		if (text.isEmpty()) {
			throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
		}
	}

	public String[] split(String text) {
		return text.split(",|:");
	}

	public String[] split(String text, String customDelimiter) {
		return text.split(customDelimiter);
	}

	public int toNumber(String text) {
		try {
			return Integer.parseUnsignedInt(text);
		} catch (NumberFormatException e) {
			throw new RuntimeException("올바른 숫자가 아닙니다.");
		}
	}

	public String getDelimiterFromText(String text) {
		return text.split("\\\\n")[0].split("//")[1];
	}
}