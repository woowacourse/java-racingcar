package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.domain.Name;

/**
 * 이름 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/12
 */
public class NameTest {
	@Test
	@DisplayName("생성자 테스트")
	void constructor() {
		Assertions.assertThat(new Name("pobi"))
				.isInstanceOf(Name.class);
	}

	@Test
	@DisplayName("이름이 null로 주어진 경우")
	void constructor_이름이_null로_주어진_경우() {
		Assertions.assertThatThrownBy(() -> new Name(null))
				.isInstanceOf(NullPointerException.class);
	}

	@Test
	@DisplayName("이름이 주어지지 않은 경우")
	void constructor_이름이_주어지지_않은_경우() {
		Assertions.assertThatThrownBy(() -> new Name(""))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름이 다섯자를 초과하는 경우")
	void constructor_이름이_다섯자를_초과하는_경우() {
		Assertions.assertThatThrownBy(() -> new Name("123456"))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@DisplayName("이름에 공백이 있는 경우")
	@ValueSource(strings = {" ", "h i", "      "})
	void constructor_이름에_공백이_있는_경우(String input) {
		Assertions.assertThatThrownBy(() -> new Name(input))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
