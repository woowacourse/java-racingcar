package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {
	@ParameterizedTest()
	@CsvSource(value = {"4,True", "3,false"})
	void 상황에_따른_전진(int randomValue, boolean expected, String testName) {
		//given
		Car car = new Car("앨런", 0);
		int initState = car.getPosition();
		//when
		car.movePositionAccordingToCondition(randomValue);
		//then
		assertThat(car.getPosition() == initState + 1).isEqualTo(expected);
	}

	@Test
	void 자동차_생성_테스트() {
		assertThatThrownBy(() -> new Car("이름길이테스트", 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("이름은 5자 이하여야 합니다.");
	}

}