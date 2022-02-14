package junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@Test
	void split() {
		String actual = "1,2";
		assertThat(actual.split(",")).contains("1", "2");
	}

	@Test
	void substring() {
		String actual = "(1,2)";
		assertThat(actual.substring(1, 4)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("String index 범위 테스트")
	void stringIndexOfTest() {
		String actual = "abc";
		assertThatThrownBy(() -> actual.charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}