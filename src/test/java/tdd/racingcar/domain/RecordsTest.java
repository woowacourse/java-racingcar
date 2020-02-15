package tdd.racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordsTest {
	@Test
	void append() {
		final Records records = new Records();
		records.append("first");
		final String expected = "first";
		final String actual = records.toString();

		assertEquals(expected, actual);
	}
}