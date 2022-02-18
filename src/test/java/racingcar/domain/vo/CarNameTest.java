package racingcar.domain.vo;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Cars.*;
import static racingcar.domain.vo.CarName.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Cars;

public class CarNameTest {

	@DisplayName("자동차 이름에")
	@Nested
	class OneNameTest {
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

	@DisplayName("자동차들을 생성시 이름에")
	@Nested
	class SeveralNamesTest {
		@ParameterizedTest
		@ValueSource(strings = {"panda,philz,jav#a", "aaa, bb@bb, cc"})
		@DisplayName("허용되지 않는 문자를 입력했을 때 예외 발생")
		public void input_all_car_name_exception(final String carNames) {
			assertThatThrownBy(
				() -> new Cars(carNames))
				.isInstanceOf(RuntimeException.class)
				.hasMessage(NOT_ALLOWED_FORMAT_MESSAGE);
		}

		@ParameterizedTest
		@ValueSource(strings = {"aa,aa,bb", " a, bb, c, a"})
		@DisplayName("이름에 중복이 들어가면 예외가 발생한다")
		public void not_duplicate_names(final String carNames) {
			assertThatExceptionOfType(RuntimeException.class).isThrownBy(
					() -> new Cars(carNames))
				.withMessage(INVALID_DUPLICATE_CAR_NAMES);
		}

		@ParameterizedTest
		@ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
		@DisplayName("정상 값을 입력했을 때 예외가 발생하지 않는다")
		public void input_all_car_name(final String carNames) {
			Assertions.assertDoesNotThrow(
				() -> new Cars(carNames)
			);
		}
	}
}
