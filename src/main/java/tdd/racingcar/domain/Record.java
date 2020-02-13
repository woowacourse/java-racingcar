package tdd.racingcar.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Record implements Iterable<String> {
	private final Queue<String> records;

	public Record() {
		records = new LinkedList<>();
	}

	public void add(final String record) {
		records.add(record);
	}

	@Override
	public Iterator<String> iterator() {
		return records.iterator();
	}
}
