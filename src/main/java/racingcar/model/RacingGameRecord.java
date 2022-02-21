package racingcar.model;

public class RacingGameRecord {

	private final String name;
	private final int position;

	public RacingGameRecord(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public static RacingGameRecord from(RacingCar racingCar){
		return new RacingGameRecord(racingCar.getName(),racingCar.getPosition());
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
