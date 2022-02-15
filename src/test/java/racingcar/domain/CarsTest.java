package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
	@Test
	@DisplayName("자동차 목록이 잘 등록되는지 테스트")
	void carsGenerate() {
		String[] carNames = {"pobi", "crong", "huan"};
		Cars cars = new Cars(carNames);
		assertThat(cars.getSize()).isEqualTo(carNames.length);
	}

}