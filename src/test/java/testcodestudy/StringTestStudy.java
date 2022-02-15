package testcodestudy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTestStudy {

	@Test
	void splitTest() {
		String input = "1";
		assertThat(input.split(",")).containsExactly("1");
	}

	@Test
	void subStringTest() {
		String input = "(1,2)";
		assertThat(input.substring(1, 4)).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt test code")
	void charAtTest() {
		String input = "abc";
		assertThatThrownBy(() -> {
			assertThat(input.charAt(4)).isEqualTo('a');
		}).isInstanceOf(IndexOutOfBoundsException.class)
				.hasMessageContaining("range: 4");
	}
}