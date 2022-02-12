package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	Cars cars;
	List<Integer> moveConditionNumbers;

	@BeforeEach
	void setUp() {
		moveConditionNumbers = new ArrayList<>(Arrays.asList(3, 4));
		cars = new Cars();
		cars.createCars(new String[] {"범고래", "소주캉"});
	}

	@Test
	@DisplayName("자동차 생성 테스트")
	void createCarsTest() {
		assertThat(cars.getSize()).isEqualTo(2);
	}

	@Test
	@DisplayName("자동차 이름 중복 체크 테스트")
	void checkDuplicationCarNamesTest() {
		String[] CarNames = {"범고래", "범고래"};
		assertThatThrownBy(() -> cars.createCars(CarNames))
			.isInstanceOf(RuntimeException.class)
			.hasMessageContaining("중복");
	}

	@Test
	@DisplayName("자동차 목록 전진 테스트")
	void moveTest() {
		cars.move(moveConditionNumbers);
		List<CarDto> cars = this.cars.getCars();

		CarDto expected = new CarDto("소주캉", 1);
		CarDto expected2 = new CarDto("범고래", 0);

		assertThat(cars.contains(expected)).isTrue();
		assertThat(cars.contains(expected2)).isTrue();
	}

	@Test
	@DisplayName("우승자 반환 테스트")
	void winnerTest() {
		cars.move(moveConditionNumbers);
		List<CarDto> winners = cars.getWinners();

		CarDto expected = new CarDto("소주캉", 1);

		assertThat(winners.contains(expected)).isTrue();
	}
}
