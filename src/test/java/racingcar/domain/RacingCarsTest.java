package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {
	@BeforeEach
	void tearDown() {
		RacingCars.clear();
	}

	@Test
	@DisplayName("RacingCars에 중복되는 이름이 없을 경우 차가 정상적으로 추가되어야한다.")
	void carAddTest() {
		RacingCars.add(new Car("woowa"));
		RacingCars.add(new Car("code"));

		assertThat(RacingCars.getCars().size()).isEqualTo(2);
	}

	@Test
	@DisplayName("RacingCars에 중복되는 이름이 있을 경우 IllegalArgumentException을 발생시켜야 한다.")
	void carAddFailTest() {
		RacingCars.add(new Car("woowa"));

		assertThatThrownBy(() -> RacingCars.add(new Car("woowa")))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
