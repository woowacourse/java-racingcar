package racingcar.Util;

import static org.assertj.core.api.Assertions.*;
import static racingcar.Util.Utils.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UtilsTest {
	@Test
	void splitAndTrim() {
		String testString = "pobi  ,  crong,huan";
		String[] result = splitter(testString);

		assertThat(result).containsExactly("pobi", "crong", "huan");
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", " ", "가"})
	@DisplayName("입력값이 숫자가 아닐 경우")
	void notInteger(String moveCount) {
		assertThatThrownBy(() -> Utils.strToInt(moveCount))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_NOT_INTEGER);
	}

	@Test
	void rangeOfRandomNumber() {
		assertThat(makeRandom()).isBetween(0, RANDOM_NUMBER_BOUND);
	}
}