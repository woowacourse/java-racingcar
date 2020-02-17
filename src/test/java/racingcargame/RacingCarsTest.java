package racingcargame;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.RacingCars;
import racingcargame.domain.car.Car;

public class RacingCarsTest {
	private List<Car> cars;

	@BeforeEach
	void setUp() {
		cars = new ArrayList<>();
		cars.add(new Car("pobi"));
		cars.add(new Car("cronx"));
	}

	@Test
	@DisplayName("생성자를 통한 createCars 테스트")
	void constructorTest() {
		Assertions.assertThat(new RacingCars("pobi,cronx")).isInstanceOf(RacingCars.class);
	}

	@Test
	@DisplayName("생성자를 통한 createCars 실패 테스트")
	void constructorFailTest() {
		Assertions.assertThatThrownBy(() -> new RacingCars(RacingCars.DELIMITER))
			.hasMessage("구분자를 기준으로 이름을 입력해주세요.");
	}

	@Test
	@DisplayName("processOneRaceTest")
	void processOneRaceTest() {
	}
}
