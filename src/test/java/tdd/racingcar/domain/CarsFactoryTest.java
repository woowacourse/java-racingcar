package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CarsFactoryTest {
	@Test
	void createCar() {
		List<String> names = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
		Cars cars = CarsFactory.create("a,b,c,d");
		List<Car> actual = new ArrayList<>();
		cars.forEach(actual::add);
		assertThat(names.size()).isEqualTo(actual.size());
	}
}
