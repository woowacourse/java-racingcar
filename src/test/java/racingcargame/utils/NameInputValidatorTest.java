package racingcargame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameInputValidatorTest {

	@DisplayName("자동차 이름이 입력되지 않는 경우 테스트")
	@Test
	void validateCarNames_Empty() {
		assertThatThrownBy(() -> {
			NameInputValidator.validateCarNames(null);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[error] 입력된 자동차 이름이 없습니다.");
	}

	@DisplayName("자동차 이름에 공백이 포함되는 경우 테스트")
	@Test
	void validateCarNames_HasBlank() {
		assertThatThrownBy(() -> {
			NameInputValidator.validateCarNames("p, ,d");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[error] 입력한 자동차 이름에 공백이 있습니다.");
	}

	@DisplayName("자동차 이름이 중복되는 경우 테스트")
	@Test
	void validateCarNames_Duplicate() {
		assertThatThrownBy(() -> {
			NameInputValidator.validateCarNames("pan,kin,day,kin");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[error] 입력한 자동차 이름 중 중복되는 이름이 있습니다.");
	}

	@DisplayName("자동차 이름길이가 1~5가 아닌 경우 테스트")
	@Test
	void validateCarNames_CarNameLength() {
		assertThatThrownBy(() -> {
			NameInputValidator.validateCarNames("pan,ffgfdr,day,kin");
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("[error] 자동차 이름을 5자 이하로 입력해주세요.");
	}
}