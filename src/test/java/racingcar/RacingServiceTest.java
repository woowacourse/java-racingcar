package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.AttemptNumber;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.RacingService;
import racingcar.util.Converter;

public class RacingServiceTest {

	private RacingService racingService;
	private CarRepository carRepository;

	@BeforeEach
	public void init() {
		racingService = new RacingService(() -> 5);
		carRepository = CarRepository.getInstance();
		String input = "pobi,joon";
		racingService.registerCars(Converter.toCarList(input));
	}

	@AfterEach
	public void afterEach() {
		carRepository.clear();
	}

	@Test
	@DisplayName("자동차 경주 정상 진행")
	public void raceTest() {
		racingService.race(AttemptNumber.from(2));

		List<Car> cars = carRepository.findCars();

		cars.forEach(car -> {
			assertThat(car.isSamePosition(2)).isTrue();
		});
	}

	@Test
	@DisplayName("자동차 경주 자동차 1대일 때 예외 발생")
	public void raceWithOneCar() {
		carRepository.clear();
		racingService.registerCars(List.of(Car.from("asd")));

		assertThatThrownBy(() -> racingService.race(AttemptNumber.from(3)))
			.isInstanceOf(IllegalStateException.class);
	}

	@Test
	@DisplayName("우승자 한 명 구하기")
	public void findWinnerOne() {
		Car car1 = Car.of("lala", 5);
		Car car2 = Car.of("good", 2);
		Car car3 = Car.of("jason", 1);

		racingService.registerCars(List.of(car1, car2, car3));

		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(1);
		assertThat(winnerNames.get(0)).isEqualTo("lala");
	}

	@Test
	@DisplayName("우승자 여러명 구하기")
	public void findWinnersTest() {
		List<String> winnerNames = racingService.findWinnerNames();
		assertThat(winnerNames.size()).isEqualTo(2);
		assertThat(winnerNames).containsSequence("pobi");
		assertThat(winnerNames).containsSequence("joon");
	}
}
