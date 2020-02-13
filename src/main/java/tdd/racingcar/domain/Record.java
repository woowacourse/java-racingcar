package tdd.racingcar.domain;

import java.util.Map;
import java.util.function.BiConsumer;

public class Record {
	private final Map<String, Integer> record;

	public Record(final Cars cars) {
		record = Map.copyOf(cars.getPositions());
	}

	public void forEach(BiConsumer<String, Integer> action) {
		record.forEach(action);
	}
}
