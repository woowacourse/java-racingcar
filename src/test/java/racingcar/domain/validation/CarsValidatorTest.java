package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class CarsValidatorTest {
	private final CarsValidator validator = new CarsValidator();
	private List<Car> cars = new ArrayList<>();

	@DisplayName("자동차 이름 중복 테스트")
	@Test
	void car_name_duplicated() {
		//given, when
		cars.add(new Car("hee"));
		cars.add(new Car("bong"));
		cars.add(new Car("bong"));
		//then
		assertThatThrownBy(() -> {
			validator.carsValid(cars);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 개수 테스트")
	@Test
	void car_count_test() {
		//given, when
		cars.add(new Car("pobi"));
		//then
		assertThatThrownBy(() -> {
			validator.carsValid(cars);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@AfterEach
	void clear() {
		cars.clear();
	}
}