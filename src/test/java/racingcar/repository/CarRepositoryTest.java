package racingcar.repository;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class CarRepositoryTest {

	@BeforeEach
	void tearDown() {
		CarRepository.clear();
	}

	@Test
	@DisplayName("CarRepository에 중복되는 이름이 없을 경우 차가 정상적으로 추가되어야한다.")
	void carAddTest() {
		CarRepository.add(new Car("woowa"));
		CarRepository.add(new Car("code"));

		assertThat(CarRepository.getCars().size()).isEqualTo(2);
	}

	@Test
	@DisplayName("CarRepository에 중복되는 이름이 있을 경우 IllegalArgumentError를 발생시켜야 한다.")
	void carAddFailTest() {
		CarRepository.add(new Car("woowa"));
		Assertions.assertThatThrownBy(() -> CarRepository.add(new Car("woowa")))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
