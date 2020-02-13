package tdd.calculator.domain;

public class UnsignedNumber {
	private final int unsignedNumber;

	public UnsignedNumber(final String unsignedNumber) {
		validate(unsignedNumber);
		this.unsignedNumber = Integer.parseInt(unsignedNumber);
	}

	private void validate(final String unsignedNumber) {
		if (isNotNumber(unsignedNumber)) {
			throw new RuntimeException("숫자 이외의 값을 입력할 수 없습니다.");
		}
		if (isNegative(unsignedNumber)) {
			throw new RuntimeException("음수를 입력할 수 없습니다.");
		}
	}

	private boolean isNotNumber(final String unsignedNumber) {
		try {
			Integer.parseInt(unsignedNumber);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private boolean isNegative(final String unsignedNumber) {
		return Integer.parseInt(unsignedNumber) < 0;
	}

	public int getValue() {
		return unsignedNumber;
	}
}
