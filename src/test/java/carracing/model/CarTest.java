package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@Test
	@DisplayName("자동차 이름의 길이가 5를 초과하는 경우 에러 발생")
	void validate_자동차이름_길이() {
		assertThatThrownBy(() -> {
			new Car("pobbiii");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_LENGTH_EXCEPTION.getMessage());
	}

	@Test
	@DisplayName("자동차 이름의 길이가 1미만인 경우 에러 발생")
	void validate_자동차이름_길이기준_미달() {
		assertThatThrownBy(() -> {
			new Car("");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(CAR_NAME_LENGTH_EXCEPTION.getMessage());
	}


	@ParameterizedTest
	@ValueSource(ints = {4, 5, 6, 7, 8, 9})
	@DisplayName("랜덤값이 4 이상으로 주어질 경우 자동차의 position이 1 증가")
	void 랜덤값_4이상이면_전진(int randomNumber) {
		//given
		Car car = new Car("pobi");
		//when
		car.move(randomNumber);
		int position = car.getPosition();
		//then
		assertThat(position).isEqualTo(1);
	}

	@ParameterizedTest
	@ValueSource(ints = {0, 1, 2, 3})
	@DisplayName("랜덤값이 4 미만으로 주어질 경우 자동차의 position 변화 없음")
	void 랜덤값_4미만이면_멈춤(int randomNumber) {
		//given
		Car car = new Car("pobi");
		int originalPosition = car.getPosition();
		//when
		car.move(randomNumber);
		int changedPosition = car.getPosition();
		//then
		assertThat(changedPosition).isEqualTo(originalPosition);
	}


}
