package racingcar.Domain;

import java.util.Objects;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */
public class TrialTime {
	private static final String TRIAL_TIME_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE = "시도할 횟수는 null일 수 없습니다.";
	private static final String INPUT_RANGE_EXCEPTION_MESSAGE = "입력가능 범위가 아닙니다. 1~100 정수만 입력해주세요.";
	public static final int INPUT_LOWER_RANGE = 1;
	public static final int INPUT_UPPER_RANGE = 100;

	private int trialTime;

	public TrialTime(final Integer inputTrialTime) {
		Objects.requireNonNull(inputTrialTime, TRIAL_TIME_CAN_NOT_BE_NULL_EXCEPTION_MESSAGE);
		validateTrialTime(inputTrialTime);
		this.trialTime = inputTrialTime;
	}

	private void validateTrialTime(final int inputTrialTime) {
		if (inputTrialTime < INPUT_LOWER_RANGE || inputTrialTime > INPUT_UPPER_RANGE) {
			throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION_MESSAGE);
		}
	}

	public int getTrialTime() {
		return this.trialTime;
	}
}
