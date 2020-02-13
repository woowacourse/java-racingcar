package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class RecordsTest {
	@Test
	void add() {
		final Records records = new Records();
		final Cars cars = CarsFactory.create("a,b,c");
		final Set<Record> expected = new HashSet<>();
		expected.add(new Record(cars));
		cars.move();
		expected.add(new Record(cars));
		records.forEach(record -> {
			assertThat(expected.contains(record)).isTrue();
		});
	}
}
