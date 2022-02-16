package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.CarFactory;
import racingcar.domain.UniqueCars;

public class UniqueCarsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@Test
	public void 중복된_이름() {
		assertThatThrownBy(() -> new UniqueCars(CarFactory.of("forky,forky")))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageStartingWith(ERROR_MESSAGE);
	}
}
