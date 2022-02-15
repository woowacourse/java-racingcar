package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;
import racingcar.util.RandomUtilImpl;

public class RacingServiceTest {

	private RacingService racingService;
	private CarRepository carRepository;

	@BeforeEach
	public void init() {
		racingService = new RacingService(bound -> bound + 5);
		carRepository = CarRepository.getInstance();
		String input = "pobi,joon";
		racingService.registerCars(Converter.toCarList(input));
	}

	@AfterEach
	public void afterEach() {
		carRepository.clear();
	}

	@Test
	public void 자동차_저장() {
		int carCount = carRepository.count();

		assertThat(carCount).isEqualTo(2);
	}

	@Test
	public void 자동차_경주() {
		racingService.race(2);

		List<Car> cars = carRepository.findCars();

		cars.forEach(car -> {
			assertThat(car.isSamePosition(2)).isTrue();
		});
	}

	@Test
	public void 자동차_경주_자동차_1대() {
		carRepository.clear();
		racingService.registerCars(List.of(Car.from("asd")));

		assertThatThrownBy(() -> racingService.race(3))
			.isInstanceOf(IllegalStateException.class);
	}

	@Test
	public void 우승자_한명_계산() {
		Car car1 = Car.of("lala", 5);
		Car car2 = Car.of("good", 2);
		Car car3 = Car.of("jason", 1);

		racingService.registerCars(List.of(car1, car2, car3));

		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(1);
		assertThat(winnerNames.get(0)).isEqualTo("lala");
	}

	@Test
	public void 우승자_여러명_계산() {
		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(2);
		assertThat(winnerNames).containsSequence("pobi");
		assertThat(winnerNames).containsSequence("joon");
	}
}
