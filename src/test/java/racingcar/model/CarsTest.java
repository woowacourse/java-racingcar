package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
	Cars cars;
	List<Integer> moveConditionNumbers;

	@BeforeEach
	void setUp() {
		moveConditionNumbers = new ArrayList<>(Arrays.asList(3, 4));
		cars = new Cars();
		cars.createCars(new String[] {"범고래", "소주캉"});
	}

	@Test
	void 자동차_목록_생성() {
		assertThat(cars.getSize()).isEqualTo(2);
	}

	@Test
	void 자동차_이름_중복() {
		String[] CarNames = {"범고래", "범고래"};
		assertThatThrownBy(() -> cars.createCars(CarNames))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("중복");
	}

	@Test
	void 게임_진행() {
		cars.move(moveConditionNumbers);
		List<CarDto> cars = this.cars.getCars();
		CarDto expected = new CarDto("소주캉", 1);
		CarDto expected2 = new CarDto("범고래", 0);
		assertThat(cars.contains(expected)).isTrue();
		assertThat(cars.contains(expected2)).isTrue();
	}

	@Test
	void 우승자() {
		cars.move(moveConditionNumbers);
		List<CarDto> winners = cars.getWinners();
		CarDto expected = new CarDto("소주캉", 1);
		assertThat(winners.contains(expected)).isTrue();
	}
}
