package tdd.racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordTest {
	@Test
	void append() {
		final Record record = new Record();
		record.append("first");
		final String expected = "first";
		final String actual = record.toString();

		assertEquals(expected, actual);
	}
}