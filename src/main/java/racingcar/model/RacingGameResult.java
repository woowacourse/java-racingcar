package racingcar.model;

import java.util.List;

public class RacingGameResult {

	private final List<List<RacingGameRecord>> racingGameRecords;

	public RacingGameResult(List<List<RacingGameRecord>> racingGameRecords) {
		this.racingGameRecords = racingGameRecords;
	}

	public void add(List<RacingGameRecord> presentCars) {

	}

	public List<List<RacingGameRecord>> getRacingGameRecords() {
		return racingGameRecords;
	}
}
