package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.racingcar.util.CarsUtils;

public class CarsTest {
	private List<Car> differentPositionCars;

	@BeforeEach
	void init() {
		differentPositionCars = CarsFactory.create("a,b,c,d").toList();
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(0).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(1).move(new Power(4));
		differentPositionCars.get(2).move(new Power(4));
	}

	@Test
	void getWinnersForEmptyCars() {
		final Cars cars = new Cars(new ArrayList<>());
		assertThatIllegalArgumentException().isThrownBy(() -> CarsUtils.getWinners(cars))
			.withMessage("차가 존재하지 않습니다.");
	}
}
