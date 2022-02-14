package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsValidatorTest {
	private final CarsValidator validator = new CarsValidator();

	@DisplayName("자동차 이름 중복 테스트")
	@Test
	void car_name_duplicated() {
		assertThatThrownBy(() -> {
			String[] names = "pobi,jun,pobi".split(",");
			validator.carsValid(names);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("자동차 개수 테스트")
	@Test
	void car_count_test() {
		assertThatThrownBy(() -> {
			String[] names = {"pobi"};
			validator.carsValid(names);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}