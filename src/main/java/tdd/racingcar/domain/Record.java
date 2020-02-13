package tdd.racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Record {
	private final Map<String, Integer> record = new HashMap<>();

	public Record(final Cars cars) {
		record.putAll(cars.getPositions());
	}

	public void forEach(BiConsumer<String, Integer> action) {
		record.forEach(action);
	}
}
