package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundTest {

	@Test
	void 음수_예외테스트() {
		assertThrows(IllegalArgumentException.class, () -> new Round(-2));
	}

	@Test
	void 제로_예외테스트() {
		assertThrows(IllegalArgumentException.class, () -> new Round(0));
	}

}
