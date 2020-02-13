package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class WinnerTest {

	@Test
	void getWinners() {
		List<Car> carList = new ArrayList<>();
		Car carPobi = new Car("pobi");
		Car carCrong = new Car("crong");

		carList.add(carPobi);
		carList.add(carCrong);
		carPobi.move(4);
		carCrong.move(4);
		carCrong.move(4);

		Assertions.assertThat(Winner.getWinners(carList)).contains("crong");
	}

	@Test
	void getWinners_When_MoreThan_2() {
		List<Car> carList = new ArrayList<>();
		Car carPobi = new Car("pobi");
		Car carCrong = new Car("crong");

		carList.add(carPobi);
		carList.add(carCrong);
		carPobi.move(4);
		carCrong.move(4);

		Assertions.assertThat(Winner.getWinners(carList)).contains("crong", "pobi");
	}
}
