package racingGame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringUtilTest {
	@Test
	void splitCarName_쉼표로_구분되어_입력된_자동차_이름(){
		final String inputCarName = "a,b,c,d";
		String[] actual = StringUtil.splitCarName(inputCarName);
		String[] expected = {"a", "b", "c", "d"};
		assertThat(actual).isEqualTo(expected);
	}
}
