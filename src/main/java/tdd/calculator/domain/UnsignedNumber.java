package tdd.calculator.domain;

public class UnsignedNumber {
	private final int unsignedNumber;

	public UnsignedNumber(final String unsignedNumber) {
		this(Integer.parseInt(unsignedNumber));
	}

	public UnsignedNumber(final int unsignedNumber) {
		validate(unsignedNumber);
		this.unsignedNumber = unsignedNumber;
	}

	private void validate(final int unsignedNumber) {
		if (isNegative(unsignedNumber)) {
			throw new RuntimeException("음수를 입력할 수 없습니다.");
		}
	}

	private boolean isNegative(final int unsignedNumber) {
		return unsignedNumber < 0;
	}

	public int getValue() {
		return unsignedNumber;
	}
}
