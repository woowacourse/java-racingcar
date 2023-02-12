package domain;

public class Trial {
	private static final String ERROR_TRIAL = "자연수로만 입력해주세요.";
	private final int trial;

	public Trial(int input) {
		validateNotZero(input);
		this.trial = input;
	}

	private void validateNotZero(int input) {
		if (input == 0) {
			throw new IllegalArgumentException(ERROR_TRIAL);
		}
	}

	public int getTrial() {
		return trial;
	}
}
