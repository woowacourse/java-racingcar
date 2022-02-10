package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class CarsGeneratorTest {

	@Test
	void 올바른_자동차_생성_검증() {
		assertThat(CarsGenerator.generateCars("pobi,crong,honux"))
			.contains(new Car("pobi"), new Car("crong"), new Car("honux"));
	}

	@Test
	void 부적절한_이름_자동차_에러_검증() {
		assertThatThrownBy(
			() -> CarsGenerator.generateCars("pobi,crdong,honux")
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> CarsGenerator.generateCars(" ,   , ")
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> CarsGenerator.generateCars(",,,,")
		).isInstanceOf(IllegalArgumentException.class);
	}
}