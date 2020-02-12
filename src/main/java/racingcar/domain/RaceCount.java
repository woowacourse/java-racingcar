package racingcar.domain;

public class RaceCount {
	private static final int MINIMUM_NATURAL_NUMBER = 1;

	private final int raceCount;

	public RaceCount(String raceCount) {
		validateRaceCountInteger(raceCount);
		validateRaceCountNaturalNumber(raceCount);
		this.raceCount = Integer.parseInt(raceCount);
	}

	private void validateRaceCountInteger(String raceCount) {
		try {
			Integer.parseInt(raceCount);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(raceCount + "는 정수가 아닙니다.");
		}
	}

	private void validateRaceCountNaturalNumber(String raceCount) {
		if (Integer.parseInt(raceCount) < MINIMUM_NATURAL_NUMBER) {
			throw new IllegalArgumentException(raceCount + "는 자연수가 아닙니다.");
		}
	}
}
