package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;

public class RacingServiceTest {

	private final RacingService racingService = new RacingService();
	private final CarRepository carRepository = new CarRepository();

	@BeforeEach
	public void init() {
		String input = "pobi,joon";
		racingService.registerCars(Converter.toCarList(input));
	}

	@AfterEach
	public void afterEach() {
		carRepository.clear();
	}

	@Test
	public void 자동차_저장() {
		CarRepository carRepository = new CarRepository();
		int carCount = carRepository.count();

		assertThat(carCount).isEqualTo(2);
	}

	@Test
	public void 자동차_경주() {
		racingService.race(bound -> 5);
		racingService.race(bound -> 5);

		List<Car> cars = carRepository.findCars();
		cars.forEach(car -> {
			assertThat(car.isSamePosition(2)).isTrue();
		});
	}

	@Test
	public void 우승자_한명_계산() {
		Car car1 = Car.of("lala", 5);
		Car car2 = Car.of("good", 2);
		Car car3 = Car.of("jason", 1);

		racingService.registerCars(List.of(car1, car2, car3));

		List<CarDto> winnerNames = racingService.findWinnerCars();
		assertThat(winnerNames.size()).isEqualTo(1);
		assertThat(winnerNames.get(0).getName()).isEqualTo("lala");
	}

	@Test
	public void 우승자_여러명_계산() {
		List<CarDto> winnerCars = racingService.findWinnerCars();
		assertThat(winnerCars.size()).isEqualTo(2);
		Stream<String> winnerCarNames = winnerCars.stream()
			.map(CarDto::getName);
		assertThat(winnerCarNames).containsSequence("pobi", "joon");
	}
}
