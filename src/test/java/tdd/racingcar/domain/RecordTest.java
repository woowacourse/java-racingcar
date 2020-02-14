package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class RecordTest {
	@Test
	void forEach() {
		Cars cars = CarsFactory.create("a,b,c");
		cars.move();
		Map<String, Integer> positions = cars.getPositions();
		Record record = new Record(cars);
		record.forEach((name, position) -> {
			assertThat(positions.get(name)).isEqualTo(position);
		});
	}
}
