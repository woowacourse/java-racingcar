package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
	public static final int GOING_NUMBER = 5;
	private Car pobi;

	@BeforeEach
	void setUp() {
		pobi = new Car("pobi");
	}

	@Test
	void constructor() {
		assertThat(pobi).isNotNull();
		assertThatThrownBy(() -> {
			new Car("moreThanFiveLetters");
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void moves() {
		Car pobiClone = new Car("pobi");
		pobi.move(GOING_NUMBER);
		pobiClone.move(GOING_NUMBER);
		assertThat(pobi.isOnSamePosition(pobiClone)).isTrue();
	}

	@Test
	void toStringTest() {
		assertThat(pobi).hasToString("pobi : \n");
		pobi.move(GOING_NUMBER);
		assertThat(pobi).hasToString("pobi : -\n");
	}
}
