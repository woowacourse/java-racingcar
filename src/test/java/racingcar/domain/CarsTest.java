package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	@DisplayName("문자열로 입력 시 자동차 개수 테스트")
	@Test
	void cars_count_string() {
		assertThatThrownBy(() -> {
			Cars cars = new Cars("pobi");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Car 객체로 입력 시 자동차 개수 테스트")
	@Test
	void cars_count() {
		assertThatThrownBy(() -> {
			List<Car> carList = new ArrayList<>();
			Car car = new Car("pobi");
			carList.add(car);

			Cars cars = new Cars(carList);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("문자열로 입력 시 자동차 이름 중복 테스트")
	@Test
	void cars_name_duplicated_string() {
		assertThatThrownBy(() -> {
			Cars cars = new Cars("pobi,jun,pobi");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("Car 객체로 입력 시 자동차 이름 중복 테스트")
	@Test
	void cars_name_duplicated() {
		assertThatThrownBy(() -> {
			List<Car> carList = new ArrayList<>();
			Car car = new Car("pobi");
			Car car2 = new Car("pobi");
			carList.add(car);
			carList.add(car2);

			Cars cars = new Cars(carList);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 랜덤 숫자 범위 확인")
	@Test
	void cars_random_range() {
		//given, when
		int value = generate();
		//then
		assertTrue(value > -1 && value < 11);
	}

	@DisplayName("우승자 1명")
	@Test
	void cars_winner() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car("car1", 2);
		Car car2 = new Car("car2", 3);
		Car car3 = new Car("car3", 1);

		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		Cars cars = new Cars(carList);

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactly("car2");
	}

	@DisplayName("우승자 2명")
	@Test
	void cars_winners() {
		List<Car> carList = new ArrayList<>();
		Car car1 = new Car("car1", 2);
		Car car2 = new Car("car2", 2);
		Car car3 = new Car("car3", 1);

		carList.add(car1);
		carList.add(car2);
		carList.add(car3);
		Cars cars = new Cars(carList);

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactly("car1", "car2");
	}

	private int generate() {
		return (int)(Math.random() * 100) % 10;
	}
}