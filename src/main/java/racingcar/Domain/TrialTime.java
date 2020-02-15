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

	private int trialTime;

	public TrialTime(Integer inputTrialTime) {
		Objects.requireNonNull(inputTrialTime, "시도할 횟수는 null일 수 없습니다.");
		validateTrialTime(inputTrialTime);
		this.trialTime = inputTrialTime;
	}

	private void validateTrialTime(int inputTrialTime) {
		if (inputTrialTime < 1 || inputTrialTime > 100) {
			throw new IllegalArgumentException("입력가능 범위가 아닙니다. 1~100 정수만 입력해주세요.");
		}
	}

	public int getTrialTime() {
		return this.trialTime;
	}
}
