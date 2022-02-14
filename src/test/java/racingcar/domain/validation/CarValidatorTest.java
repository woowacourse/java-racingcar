package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarValidatorTest {

	private final CarValidator validator = new CarValidator();

	@DisplayName("자동차 이름 공백 테스트")
	@ParameterizedTest
	@ValueSource(strings = {" "})
	void car_name_empty(String name) {
		assertThatThrownBy(() -> {
			validator.checkBlank(name, "자동차 이름은 공백일 수 없습니다.");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 이름 null 테스트")
	@Test
	void car_name_null() {
		assertThatThrownBy(() -> {
			validator.checkBlank(null, "자동차 이름은 null 일 수 없습니다.");
		}).isInstanceOf(NullPointerException.class);
	}

	@DisplayName("자동차 이름 길이 테스트")
	@Test
	void car_name_length() {
		assertThatThrownBy(() -> {
			validator.carValid("gooddd");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}