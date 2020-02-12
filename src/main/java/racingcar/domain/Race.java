package racingcar.domain;

public class Race {
	public static final int MINIMUM_NATURAL_NUMBER = 1;

	private final Cars cars;
	private final int raceCount;

	public Race(Cars cars, String raceCount) {
		validateRaceCountInteger(raceCount);
		validateRaceCountNaturalNumber(raceCount);

		this.cars = cars;
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
