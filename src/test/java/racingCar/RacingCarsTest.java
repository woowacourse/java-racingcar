package racingCar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingCar.domain.Car;
import racingCar.domain.RacingCars;

public class RacingCarOutputTest {
	@Test
	void 자동차_위치_출력_정상() {
		Car car = new Car("woowahan");
		car.moveCar(true);
		assertThat(car.toString()).isEqualTo("woowahan : -");
		car.moveCar(false);
		assertThat(car.toString()).isEqualTo("woowahan : -");
		car.moveCar(true);
		assertThat(car.toString()).isEqualTo("woowahan : --");
	}

	@Test
	void 최종_결과_출력_정상() {
		RacingCars racingCars;
		List<Car> cars = new ArrayList<>();
		List<Car> winners = new ArrayList<>();

		Car car1 = new Car("a");
		Car car2 = new Car("b");
		Car car3 = new Car("c");

		cars.add(car1);
		cars.add(car2);
		cars.add(car3);

		cars.get(0).moveCar(true);
		cars.get(0).moveCar(true);
		cars.get(1).moveCar(true);
		cars.get(1).moveCar(true);
		cars.get(2).moveCar(false);

		winners.add(car1);
		winners.add(car2);

		racingCars = new RacingCars(cars);

		List<Car> result = racingCars.findWinner();
		assertThat(result).isEqualTo(winners);
	}

}
