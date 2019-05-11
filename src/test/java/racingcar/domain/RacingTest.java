package racingcar.domain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RacingTest {
	private Car car;

	@Before
	public void init() {
		car = new Car("Test");
	}

	@Test
	public void 랜덤숫자가_3이하인_경우() {
		car.moveOrNot(3);
		assertTrue(car.matchPosition(0));
	}

	@Test
	public void 랜덤숫자가_4이상인_경우() {
		car.moveOrNot(4);
		assertTrue(car.matchPosition(1));
	}
}