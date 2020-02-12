package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private List<Car> differentPositionCars;

	@BeforeEach
	void init() {
		differentPositionCars = new ArrayList<>();
		CarsFactory.create("a,b,c,d").forEach(differentPositionCars::add);
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(2).move(new Power(4));
	}

	@Test
	void getWinnersForEmptyCars() {
		final Cars cars = new Cars(new ArrayList<>());
		assertThatIllegalArgumentException().isThrownBy(cars::getWinners)
				.withMessage("차가 존재하지 않습니다.");
	}

	@Test
	void getWinners() {
		final Cars cars = new Cars(differentPositionCars);
		final List<Car> expected = Arrays.asList(differentPositionCars.get(0), differentPositionCars.get(1));
		final List<Car> actual = cars.getWinners();
		assertEquals(expected, actual);
	}
}
