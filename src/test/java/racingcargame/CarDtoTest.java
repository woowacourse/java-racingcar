package racingcargame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.car.CarDto;

class CarDtoTest {
	@Test
	@DisplayName("생성자 테스트")
	void constructorTest() {
		Assertions.assertThat(new CarDto("car", 3)).isEqualTo(new CarDto("car", 3));

		Assertions.assertThat(new CarDto("car", 3)).isNotEqualTo(new CarDto("car", 4));
		Assertions.assertThat(new CarDto("car", 3)).isNotEqualTo(new CarDto("car0", 3));
	}

	@Test
	@DisplayName("isPositionOf 테스트")
	void isPositionOfTest() {
		CarDto carDto = new CarDto("car", 6);
		Assertions.assertThat(carDto.isPositionOf(6)).isTrue();
		Assertions.assertThat(carDto.isPositionOf(4)).isFalse();
	}
}
