package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private List<Car> carList = new ArrayList<>();
	private Car pobi = new Car("pobi");
	private Car kyle = new Car("kyle");
	private Car hodol = new Car("hodol");
	private Car rutgo = new Car("rutgo");

	@BeforeEach
	void generateCarList() {
		pobi.move(CarTest.GOING_NUMBER);
		pobi.move(CarTest.GOING_NUMBER);
		kyle.move(CarTest.GOING_NUMBER);
		rutgo.move(CarTest.GOING_NUMBER);
		carList.add(hodol);
		carList.add(pobi);
		carList.add(kyle);
		carList.add(rutgo);
	}

	@Test
	void sort() {
		Cars cars = new Cars(carList);
		Car sort = cars.getCarOnMaxPosition();
		assertThat(sort).isEqualTo(pobi);
	}

	@Test
	void checkIfIsOnSamePosition() {
		assertThat(kyle.isOnSamePosition(rutgo)).isTrue();
	}
}
