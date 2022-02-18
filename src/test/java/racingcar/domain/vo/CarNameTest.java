package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.vo.CarName.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 이름에 ")
public class CarNameTest {

	@ParameterizedTest
	@ValueSource(strings = {",", "#", "#phiz", "ph,bi"})
	@DisplayName("허용되지 않는 문자를 입력했을 때 예외가 발생한다")
	public void Not_Available_Character(String carName) {
		assertThatThrownBy(
			() -> new CarName(carName))
			.isInstanceOf(RuntimeException.class)
			.hasMessage(NOT_ALLOWED_FORMAT_MESSAGE);

	}

	@Test
	@DisplayName("null을 입력했을 때 예외가 발생한다")
	public void Not_Available_Null() {
		assertThatThrownBy(
			() -> new CarName(null))
			.isInstanceOf(RuntimeException.class)
			.hasMessage(INVALID_CAR_NAME_SHOULD_BE_ONE_MORE_CHARACTER);
	}

	@Test
	@DisplayName("차 이름이 5글자를 넘어갔을 경우 예외가 발생한다")
	public void input_car_name_exceed_length() {
		assertThatThrownBy(
			() -> new CarName("abcdef"))
			.isInstanceOf(RuntimeException.class)
			.hasMessage(EXCEED_LENGTH_ERROR_MESSAGE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "aa", "philz"})
	@DisplayName("정상 입력을 했을 때 예외가 발생하지 않는다")
	public void Available_Character(String carName) {
		Assertions.assertDoesNotThrow(
			() -> new CarName(carName));
	}
}
