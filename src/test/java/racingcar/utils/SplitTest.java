package racingcar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class SplitTest {
	@Test
	@DisplayName("자동차 이름을 쉼표(,) 기준으로 분리 테스트")
	void splitNameTest() {
		// given
		String values = "pobi,crong,honux";
		String[] expected = {"pobi", "crong", "honux"};
		// when
		String[] result = StringUtils.splitInputName(values);
		//then
		Assertions.assertArrayEquals(expected,result);
	}
}
