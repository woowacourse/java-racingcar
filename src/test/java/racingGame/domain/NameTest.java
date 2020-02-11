package racingGame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingGame.domain.Name;

public class NameTest {
	@Test
	void checkValidLength_자동차_이름의_길이가_5를_초과() {
		final String name = "abcdef";

		assertThatThrownBy(() -> new Name(name))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
