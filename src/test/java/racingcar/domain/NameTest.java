package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.exception.DuplicateCarNameException;
import racingcar.exception.EmptyCarNameException;
import racingcar.exception.OutOfCarNameLengthException;

public class NameTest {

	@Test
	void 자동차_이름의_길이가_5보다_크면_예외를_던진다() {
		String carName = "slowwwwww";

		assertThatThrownBy(() -> new Name(carName))
			.isInstanceOf(OutOfCarNameLengthException.class);
	}

	@Test
	void 자동차_이름이_공백이면_예외를_던진다() {
		String carName = "";

		assertThatThrownBy(() -> new Name(carName))
			.isInstanceOf(EmptyCarNameException.class);
	}

	@Test
	void 자동차_이름이_중복되면_예외를_던진다() {
		String[] names = {"slow ", "pobi", "if", "slow"};

		assertThatThrownBy(() -> Cars.of(names))
			.isInstanceOf(DuplicateCarNameException.class);
	}

	@Test
	void 자동차_이름은_공백을_제거하고_저정한다() {
		Name name = new Name("slow ");
		String expected = "slow";

		assertThat(name.getName()).isEqualTo(expected);
	}
}
