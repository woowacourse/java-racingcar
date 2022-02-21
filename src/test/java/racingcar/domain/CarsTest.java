package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

	private Cars cars;

	@BeforeEach
	public void init() {
		cars = new Cars();
	}

	@Test
	@DisplayName("우승자 한명 계산")
	public void findWinner() {
		cars.add(List.of(Car.of("lala", 5)));
		List<Car> winnerCars = cars.findWinnerCars();

		Assertions.assertThat(winnerCars.size()).isEqualTo(1);
		Assertions.assertThat(winnerCars.get(0).getName()).isEqualTo("lala");
	}

	@Test
	@DisplayName("우승자 여러명 계산")
	public void findWinners() {
		cars.add(List.of(Car.of("lala", 5), Car.of("pobi", 15), Car.of("joon", 15)));
		List<Car> winnerCars = cars.findWinnerCars();
		Assertions.assertThat(winnerCars.size()).isEqualTo(2);
		List<String> winnerCarNames = winnerCars.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		Assertions.assertThat(winnerCarNames).containsSequence("pobi", "joon");
	}
}
