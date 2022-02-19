package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
	private RacingCars racingCars;

	@BeforeEach
	@DisplayName("RacingCars 객체 생성")
	void setup() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("runa"));
		cars.add(new Car("leo"));
		cars.add(new Car("pobi"));
		racingCars = new RacingCars(cars);
	}

	@Test
	@DisplayName("RacingCars 불변 확인")
	void carsNotBeChanged() {
		RacingCars racingCars = new RacingCars(this.racingCars.getRacingCars());

		List<Car> unmodifiableCars = racingCars.getRacingCars();

		assertThatThrownBy(() -> unmodifiableCars.add(new Car("dun")))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("승자 확인")
	void findWinnerTest() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("runa"));
		cars.add(new Car("leo"));
		cars.add(new Car("pobi"));

		Car car = new Car("dun");
		car.moveCar(true);
		cars.add(car);
		racingCars = new RacingCars(cars);

		List<Car> winners = racingCars.findWinner();

		assertThat(winners.get(0).getName()).isEqualTo("dun");
	}

}
