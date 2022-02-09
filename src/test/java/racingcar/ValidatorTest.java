package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.validator.Validator;

public class ValidatorTest {

	@ParameterizedTest
	@ValueSource(strings = {"abcdef,asd", "abcdefgh,ase"})
	public void 자동차_이름_길이_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofCarNames(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5글자 이하여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {",dfd"})
	public void 자동차_이름_빈문자열_예외(String name) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofCarNames(name);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 1글자 이상이어야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abcde,dfsd", "abcm,er"})
	public void 자동차_이름_정상_입력(String name) {
		Validator.ofCarNames(name);
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc", "awer"})
	public void 자동차_개수_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofCarNames(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차는 2대 이상이어야 합니다");
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc,a", "awer,b"})
	public void 자동차_개수_정상(String input) {
		Validator.ofCarNames(input);
	}

	@ParameterizedTest
	@ValueSource(strings = {"아라", "abc"})
	public void 시도횟수_타입_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 숫자여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0"})
	public void 시도횟수_범위_예외(String input) {
		Assertions.assertThatThrownBy(() -> {
				Validator.ofAttemptNumber(input);
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("시도 횟수는 1회 이상이어야 합니다.");
	}


	@ParameterizedTest
	@ValueSource(strings = {"3", "344"})
	public void 시도횟수_정상(String input) {
		Validator.ofAttemptNumber(input);
	}
}
