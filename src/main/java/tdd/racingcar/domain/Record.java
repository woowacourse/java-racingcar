package tdd.racingcar.domain;

public class Record {
	private final StringBuilder records;

	public Record() {
		records = new StringBuilder();
	}

	public void append(final String record) {
		records.append(record);
	}

	@Override
	public String toString() {
		return records.toString();
	}
}
