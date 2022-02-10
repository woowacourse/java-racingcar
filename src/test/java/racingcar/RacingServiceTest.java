package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;

public class RacingServiceTest {

	@Test
	public void 자동차_저장() {
		String input = "pobi,joon";

		RacingService racingService = new RacingService();
		racingService.registerCars(Converter.toCarList(input));

		CarRepository carRepository = new CarRepository();
		int carCount = carRepository.count();

		assertThat(carCount).isEqualTo(2);
	}

	@Test
	public void 자동차_경주() {
		String input = "pobi,joon";

		RacingService racingService = new RacingService();
		racingService.registerCars(Converter.toCarList(input));

		int attemptNumber = 2;
		racingService.race(attemptNumber, bound -> 5);

		CarRepository carRepository = new CarRepository();
		List<Car> cars = carRepository.findCars();

		cars.forEach(car -> {
			assertThat(car.isSamePosition(attemptNumber)).isTrue();
		});
	}
}
