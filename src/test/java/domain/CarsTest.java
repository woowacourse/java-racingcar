package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차들의")
class CarsTest {
	List<Car> cars;

	@BeforeEach
	public void initialize() {
		cars = new ArrayList<>(List.of(new Car("benz"), new Car("honda"), new Car("audi")));
	}

	@DisplayName("총 개수 테스트")
	@Test
	void checkCarsSize() {
		assertThat(cars.size()).isEqualTo(3);

		cars.add(new Car("ford"));
		assertThat(cars.size()).isEqualTo(4);
	}
}
