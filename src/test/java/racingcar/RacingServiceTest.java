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

public class RacingServiceTest {

	private final RacingService racingService = new RacingService();
	private final CarRepository carRepository = new CarRepository();

	@BeforeEach
	public void beforeEach() {
		racingService.registerCars(List.of(new CarDto("pobi", 0), new CarDto("joon", 0)));
	}

	@AfterEach
	public void afterEach() {
		carRepository.clear();
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
		carRepository.add(List.of(Car.of("lala", 5)));

		List<CarDto> winnerCars = racingService.findWinnerCars();
		assertThat(winnerCars.size()).isEqualTo(1);
		assertThat(winnerCars.get(0).getName()).isEqualTo("lala");
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
