package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

	private List<List<CarDto>> records = new ArrayList<>();

	public void addRecord(List<CarDto> record) {
		records.add(record);
	}

	public List<List<CarDto>> get() {
		return records;
	}
}
