package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class WinnerTest {
	@Test
	public void 우승자를_찾는다() {
		List<Car> cars = new ArrayList<>(Arrays.asList(new Car("a", 1), new Car("b", 2), new Car("c", 3)));
		assertTrue(new Winner(cars, 3).getWinner().get(0).equals("c"));
	}

}