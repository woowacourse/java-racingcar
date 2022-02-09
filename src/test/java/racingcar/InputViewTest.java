package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.Validator;

public class InputViewTest {

	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "abcdefgh"})
	public void 자동차_이름_길이_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofCarName(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5글자 이하여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {""})
	public void 자동차_이름_빈문자열_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
			Validator.ofCarName(name);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1글자 이상이어야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcde", "abc"})
	public void 자동차_이름_정상_입력(String name) {
		Validator.ofCarName(name);
	}
}
