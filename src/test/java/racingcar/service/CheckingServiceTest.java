package racingcar.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckingServiceTest {

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {" ", "   ", "\t", "\n"})
	public void 자동차_이름_공백(String inputName) {
		assertThatThrownBy(() -> CheckingService.checkCarNamesBlank(inputName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"배카라쿠베네", "asdasdasd", "아스피배카라"})
	public void 자동차_이름_예외처리(String inputName) {
		assertThatThrownBy(() -> CheckingService.checkCarNameLength(inputName))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "sdfs", "two"})
	public void 횟수_숫자_확인(String turn) {
		assertThatThrownBy(() -> CheckingService.checkGameTurnNumber(turn))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "0", "-100"})
	public void 횟수_양수_확인(String turn) {
		assertThatThrownBy(() -> CheckingService.checkGameTurnNumber(turn))
			.isInstanceOf(IllegalArgumentException.class);
	}
	
}
