package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

	private List<List<CarDto>> racingResult = new ArrayList<>();

	public void addRecord(List<CarDto> record) {
		racingResult.add(record);
	}

	public List<List<CarDto>> getRacingRecords() {
		return racingResult;
	}
}
