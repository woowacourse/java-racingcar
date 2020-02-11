import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.Split;

public class split {
	@Test
	@DisplayName("콤마와 콜론으로 문자열 분리")
	void splitByCommaOrColon() {
		String value1 = "1,2:3";
		String[] result = Split.splitByCommaOrColon(value1);
		String[] expected = {"1", "2", "3"};

		Assertions.assertArrayEquals(expected, result);
	}
}
