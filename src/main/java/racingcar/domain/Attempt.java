package racingcar.domain;

import racingcar.domain.validation.AttemptValidator;

public class Attempt {
	private final int attempt;

	public Attempt(String attempt) {
		AttemptValidator.attemptValid(attempt);
		this.attempt = Integer.parseInt(attempt);
	}

	public boolean isSame(int nowAttempt) {
		return attempt == nowAttempt;
	}
}
