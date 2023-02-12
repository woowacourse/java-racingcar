package racingcar.domain.car;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 이름 ")
class CarNameTest {
	@DisplayName("생성 성공 테스트")
	@Test
	void createSuccessTest() {
		assertDoesNotThrow(() -> new CarName("헤나"));
	}

	@DisplayName("공백 및 null일시 생성 실패 테스트")
	@ParameterizedTest(name = "failedName = {0}")
	@NullAndEmptySource
	void createNameNullOrBlankFailTest(String name) {
		assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("다섯 글자 초과시 생성 실패 테스트")
	@ParameterizedTest(name = "failedName = {0}")
	@ValueSource(strings = {"헤나소니헤나", "헤나소니헤나소니헤나", "헤나소니헤나소니헤나소니헤나소니헤나"})
	void createNameOverLengthFailTest(String name) {
		assertThatThrownBy(() -> new CarName(name))
			.isInstanceOf(IllegalArgumentException.class);
	}
}