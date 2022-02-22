package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

	@DisplayName("우승자 1명")
	@Test
	void cars_winner() {
		Cars cars = new Cars(get_winner_cars());

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactly("car2");
	}

	private List<Car> get_winner_cars() {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("car1"); // position : 2
		Car car2 = new Car("car2"); // position : 3
		Car car3 = new Car("car3"); // position : 1

		Movable movable = () -> true;
		car1.drive(movable);
		car1.drive(movable);
		car2.drive(movable);
		car2.drive(movable);
		car2.drive(movable);
		car3.drive(movable);

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		return cars;
	}

	@DisplayName("우승자 2명")
	@Test
	void cars_winners() {
		Cars cars = new Cars(get_cars_winners());

		List<String> winners = cars.findWinners();

		assertThat(winners).containsExactly("car1", "car2");
	}

	private List<Car> get_cars_winners() {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("car1"); // position : 2
		Car car2 = new Car("car2"); // position : 2
		Car car3 = new Car("car3"); // position : 1

		Movable movable = () -> true;
		car1.drive(movable);
		car1.drive(movable);
		car2.drive(movable);
		car2.drive(movable);
		car3.drive(movable);

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		return cars;
	}
}