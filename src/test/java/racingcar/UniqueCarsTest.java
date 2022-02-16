package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.UniqueCars;
import racingcar.domain.util.CarFactory;

public class UniqueCarsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	@DisplayName("차 이름 중복일 때 exception 발생")
	public void duplicated_car_name_exception() {
		assertThatThrownBy(() -> new UniqueCars(CarFactory.of("forky,forky")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}
}
