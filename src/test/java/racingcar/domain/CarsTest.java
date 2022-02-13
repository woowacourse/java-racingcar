package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.vo.CarName.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차들을 생성시 이름에")
class CarsTest {

	@ParameterizedTest
	@ValueSource(strings = {"panda,philz,jav#a", "aaa, bb@bb, cc"})
	@DisplayName("허용되지 않는 문자를 입력했을 때")
	public void input_all_car_name_exception(String carNames) {
		assertThatThrownBy(
			() -> new Cars(carNames))
			.isInstanceOf(RuntimeException.class)
			.hasMessage(NOT_ALLOWED_FORMAT_MESSAGE);
	}

	@ParameterizedTest
	@ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
	@DisplayName("정상 값을 입력했을 때")
	public void input_all_car_name(String carNames) {
		Assertions.assertDoesNotThrow(
			() -> new Cars(carNames)
		);
	}

	@ParameterizedTest
	@ValueSource(strings = {"aa,aa,bb", " , a, bb, c, a"})
	@DisplayName("이름에 중복이 들어가면 아니된다")
	public void not_duplicate_names(String carNames) {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(
			() -> new Cars(carNames)
		);
	}

}