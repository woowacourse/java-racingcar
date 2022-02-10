package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;

public class RacingServiceTest {

	@AfterEach
	public void beforeEach() {
		CarRepository carRepository = new CarRepository();
		carRepository.clear();
	}

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

		racingService.race(bound -> 5);
		racingService.race(bound -> 5);

		CarRepository carRepository = new CarRepository();
		List<Car> cars = carRepository.findCars();

		cars.forEach(car -> {
			assertThat(car.isSamePosition(2)).isTrue();
		});
	}

	@Test
	public void 우승자_한명_계산() {
		Car car1 = Car.of("pobi");
		Car car2 = Car.of("good");
		Car car3 = Car.of("jun");

		car1.move(5);
		car1.move(5);
		car1.move(5);
		car2.move(5);

		RacingService racingService = new RacingService();
		racingService.registerCars(List.of(car1, car2, car3));

		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(1);
		assertThat(winnerNames.get(0)).isEqualTo("pobi");
	}

	@Test
	public void 우승자_여러명_계산() {
		Car car1 = Car.of("pobi");
		Car car2 = Car.of("good");
		Car car3 = Car.of("jun");

		RacingService racingService = new RacingService();
		racingService.registerCars(List.of(car1, car2, car3));

		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(3);
		assertThat(winnerNames).containsSequence("pobi");
		assertThat(winnerNames).containsSequence("good");
		assertThat(winnerNames).containsSequence("jun");
	}
}
