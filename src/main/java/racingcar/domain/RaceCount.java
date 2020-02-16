package racingcar.domain;

public class RaceCount {
	private static final int MINIMUM_NATURAL_NUMBER = 1;
	private static final int INITIAL_COUNT = 0;

	private final int raceCount;
	private int currentCount;

	public RaceCount(String raceCount) {
		validateRaceCountInteger(raceCount);
		validateRaceCountNaturalNumber(Integer.parseInt(raceCount));

		this.raceCount = Integer.parseInt(raceCount);
		this.currentCount = INITIAL_COUNT;
	}

	private void validateRaceCountInteger(String raceCount) {
		try {
			Integer.parseInt(raceCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(raceCount + "는 정수가 아닙니다.");
		}
	}

	private void validateRaceCountNaturalNumber(int raceCount) {
		if (raceCount < MINIMUM_NATURAL_NUMBER) {
			throw new IllegalArgumentException(raceCount + "는 자연수가 아닙니다.");
		}
	}

	public void increaseCurrentCount() {
		currentCount++;
	}

	public boolean isEnd() {
		return currentCount == raceCount;
	}
}
