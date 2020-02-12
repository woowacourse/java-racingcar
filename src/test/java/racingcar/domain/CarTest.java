package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CarTest {
	public static final int GOING_NUMBER = 5;

	@Test
	void constructor() {
		assertThatThrownBy(() -> {
			new Car("moreThanFiveLetters");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void create() {
		assertThat(new Car("pobi"));
	}

	@Test
	void moves() {
		Car pobi = new Car("pobi");
		Car pobiClone = new Car("pobi");
		pobi.move(GOING_NUMBER);
		pobiClone.move(GOING_NUMBER);
		assertThat(pobi.isOnSamePosition(pobiClone)).isTrue();
	}
}
