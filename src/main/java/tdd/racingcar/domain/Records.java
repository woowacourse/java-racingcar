package tdd.racingcar.domain;

public class Records {
	private String records;

	public Records() {
		records = "";
	}

	public void append(final String record) {
		records += record;
	}

	@Override
	public String toString() {
		return records;
	}
}
