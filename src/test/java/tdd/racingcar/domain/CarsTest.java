package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private List<Car> differentPositionCars;

	@BeforeEach
	void init() {
		differentPositionCars = new ArrayList<>();
		CarsFactory.create("a,b,c,d").stream()
				.forEach(differentPositionCars::add);
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(2).move(new Power(4));
	}

	@Test
	void getWinnersForEmptyCars() {
		final Cars cars = new Cars(new ArrayList<>());
		assertThatNullPointerException().isThrownBy(cars::getWinnerNames)
			.withMessage("차가 존재하지 않습니다.");
	}

	@Test
	void getWinnersForDifferentPositionCars() {
		Cars cars = new Cars(differentPositionCars);
		List<Name> expected = new ArrayList<>(Arrays.asList(new Name("a"), new Name("b")));
		List<Name> actual = cars.getWinnerNames();

		assertEquals(expected.get(0).toString(), actual.get(0).toString());
		assertEquals(expected.get(1).toString(), actual.get(1).toString());
	}
}
