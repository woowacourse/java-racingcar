package racingcar.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class WinnerTest {
	private List<Car> cars;

	@Before
	public void init() {
		cars = Arrays.asList(new Car("a"), new Car("b"), new Car("c"));
		cars.get(0).moveOrNot(4);
		cars.get(1).moveOrNot(4);
		cars.get(1).moveOrNot(4);
		cars.get(2).moveOrNot(4);
	}

	@Test
	public void 우승자가_한명인_경우() {
		Winner winner = new Winner(cars, 2);
		assertTrue(winner.getWinner().equals(Arrays.asList(cars.get(1).toString())));
	}

	@Test
	public void 우승자가_여러명인_경우() {
		cars.get(2).moveOrNot(4);
		Winner winner = new Winner(cars, 2);
		assertTrue(winner.getWinner().equals(Arrays.asList(cars.get(1).toString(), cars.get(2).toString())));
	}

}