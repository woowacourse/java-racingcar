package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RoundTest {

	@Test
	void 이동_횟수_정상() {
		Round round = new Round("2");
		assertThat(round.getCount()).isEqualTo(2);
	}

	@Test
	void 이동_횟수_음수_예외() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Round(("-2"));
		});
	}

	@Test
	void 이동_횟수_숫자_이외의_값_입력_예외() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Round(("-2aa"));
		});

	}
}
