package racingCar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
	private RacingCars racingCars;

	@BeforeEach
	@DisplayName("RacingCars 객체 생성")
	void setup() {
		racingCars = new RacingCars(List.of("leo", "runa", "pobi"));
	}

	@Test
	@DisplayName("RacingCars 불변 확인")
	void carsNotBeChanged() {
		List<Car> unmodifiableCars = racingCars.getRacingCars();

		assertThatThrownBy(() -> unmodifiableCars.add(new Car("dun")))
			.isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@DisplayName("승자 확인")
	void findWinnerTest() {
		List<Car> winners = racingCars.findWinner();
		winners.get(0).moveCar(true);

		assertThat(winners.get(0).getName()).isEqualTo("leo");
	}

}
