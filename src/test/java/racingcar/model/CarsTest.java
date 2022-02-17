package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
	private Cars cars;
	private List<Integer> moveConditionNumbers;

	@BeforeEach
	void setUp() {
		moveConditionNumbers = Arrays.asList(3, 4);
		cars = new Cars();
		cars.createCars(new String[] {"범고래", "소주캉"});
	}

	@Test
	@DisplayName("2 대의 자동차 생성 테스트")
	void createCarsTest() {
		assertThat(cars.getSize()).isEqualTo(2);
	}

	@Test
	@DisplayName("자동차 이름이 중복이면 예외 발생")
	void checkDuplicationCarNamesTest() {
		String[] CarNames = {"범고래", "범고래"};
		assertThatThrownBy(() -> cars.createCars(CarNames))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("중복");
	}

	@Test
	@DisplayName("전달되는 숫자 리스트 크기가 작을 경우 예외 발생")
	void validRandomsSizeTest() {
		List<Integer> integers = Collections.singletonList(1);
		assertThatThrownBy(() -> cars.moveAll(integers))
			.isInstanceOf(IllegalStateException.class)
			.hasMessageContaining("리스트 크기가 작습니다");
	}

	@Test
	@DisplayName("자동차 목록 전진 테스트, 두 번째 Car만 전진")
	void moveTest() {
		Car carStop = new Car("범고래");
		Car carMove = new Car("소주캉");

		carMove.move(4);
		cars.moveAll(moveConditionNumbers);
		List<CarDto> expected = Arrays.asList(new CarDto(carStop), new CarDto(carMove));

		assertThat(cars.getCars()).isEqualTo(expected);
	}

	@Test
	@DisplayName("우승자 반환 테스트")
	void winnerTest() {
		Car carMove = new Car("소주캉");
		carMove.move(4);
		List<CarDto> expected = Collections.singletonList(new CarDto(carMove));

		cars.moveAll(moveConditionNumbers);
		List<CarDto> winners = cars.getWinners();

		assertThat(winners).isEqualTo(expected);
	}
}
