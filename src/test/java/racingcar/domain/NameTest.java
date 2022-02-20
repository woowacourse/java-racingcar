package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Name.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
	@Test
	@DisplayName("이름이 5자 초과일 경우")
	void longName() {
		assertThatThrownBy(() -> new Name("summer"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_LONG_NAME);
	}

	@Test
	@DisplayName("빈 이름이 주어지거나 입력값이 없을 경우")
	void emptyName() {
		assertThatThrownBy(() -> new Name(""))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR_EMPTY_NAME);
	}
}
