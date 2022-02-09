package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class StringTest {
	@DisplayName("1과 2로 분리되는지 테스트")
	@Test
	void split() {
		String actual = "1,2";
		Assertions.assertThat(actual.split(",")).contains("1", "2");
	}

	@DisplayName("숫자 하나만 입력했을 경우 잘 분리되는지 테스트")
	@Test
	void split2() {
		String actual = "1";
		Assertions.assertThat(actual.split(",")).containsExactly("1");
	}

	@DisplayName("괄호가 제거되는지 테스트")
	@Test
	void substring() {
		String actual = "(1,2)";
		Assertions.assertThat(actual.substring(1,4)).isEqualTo("1,2");
	}

	@DisplayName("특정 위치에 문자를 반환하는지 테스트")
	@Test
	void charAt() {
		String actual = "abc";
		Assertions.assertThat(actual.charAt(0)).isEqualTo('a');
		Assertions.assertThat(actual.charAt(1)).isEqualTo('b');
		Assertions.assertThat(actual.charAt(2)).isEqualTo('c');
		Assertions.assertThatThrownBy(() -> actual.charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage("String index out of range: 3");
	}
}
