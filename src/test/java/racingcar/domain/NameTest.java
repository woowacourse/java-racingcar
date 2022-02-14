package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

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
		List<Name> names = Arrays.asList(
			new Name("slow"),
			new Name("pobi"),
			new Name("if"),
			new Name("slow")
		);

		assertThatThrownBy(() -> new Names(names))
			.isInstanceOf(DuplicateCarNameException.class);
	}
}
