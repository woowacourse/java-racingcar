package racingCar;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingCar.domain.Car;
import racingCar.domain.RacingCars;

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
	void carsNotBeChanged(){
		RacingCars racingCars = new RacingCars(this.racingCars.getRacingCars());

		List<Car> unmodifiableCars = racingCars.getRacingCars();

		assertThatThrownBy(()->unmodifiableCars.add(new Car("dun")))
			.isInstanceOf(UnsupportedOperationException.class);
	}


}
