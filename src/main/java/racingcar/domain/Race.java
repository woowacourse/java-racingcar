package racingcar.domain;

public class Race {
	private final Cars cars;
	private final int raceCount;

	public Race(Cars cars, String raceCount) {
		validateRaceCountInteger(raceCount);
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
}
