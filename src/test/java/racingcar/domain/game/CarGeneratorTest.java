package racingcar.domain.game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 생성기")
class CarGeneratorTest {
	@DisplayName("생성 성공 테스트")
	@ParameterizedTest(name = "name = {0}")
	@ValueSource(strings = {"헤나", "소니"})
	void generateCarSuccessTest(String name) {
		assertDoesNotThrow(() -> CarGenerator.from(name));
	}

	@DisplayName("생성 실패 테스트")
	@ParameterizedTest(name = "wrongName = {0}")
	@ValueSource(strings = {"헤나소니헤나소니", "헤나소니헤나소니헤나소니헤나소니", "", " "})
	void generateCarExceptionTest(String name) {
		assertThatThrownBy(() -> CarGenerator.from(name))
			.isInstanceOf(IllegalArgumentException.class);
	}
}