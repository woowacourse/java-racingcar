package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CarsTest {
	@Test
	@DisplayName("자동차 목록이 잘 등록되는지 테스트")
	void carsGenerate() {
		String[] carNames = {"pobi", "crong", "huan"};
		Cars cars = new Cars(carNames);
		assertThat(cars.getCars().size()).isEqualTo(carNames.length);
	}

	@Test
	@DisplayName("우승자가 한 명인 경우 테스트")
	void getOneWinner() {
		List<Car> carList = Arrays.asList(
			new Car("pobi", 2),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Cars cars = new Cars(carList);
		assertThat(cars.getWinners().stream().map(Car::getName)).contains("crong");
	}

	@Test
	@DisplayName("우승자가 여러명인 경우 테스트")
	void getSeveralWinner() {
		List<Car> carList = Arrays.asList(
			new Car("pobi", 3),
			new Car("crong", 3),
			new Car("honux", 1)
		);
		Cars cars = new Cars(carList);
		assertThat(cars.getWinners().stream().map(Car::getName)).contains("pobi", "crong");
	}
}