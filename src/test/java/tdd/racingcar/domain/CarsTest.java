package tdd.racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {
	private List<Car> DifferentPositionCars;

	@BeforeEach
	void init() {
		DifferentPositionCars = CarFactory.create(Arrays.asList("a", "b", "c", "d"));
		DifferentPositionCars.get(0).move(new Power(4));
		DifferentPositionCars.get(0).move(new Power(4));
		DifferentPositionCars.get(1).move(new Power(4));
		DifferentPositionCars.get(1).move(new Power(4));
		DifferentPositionCars.get(2).move(new Power(4));
	}

	@Test
	void getMaxPosition() {
		Cars cars = new Cars(DifferentPositionCars);
		final int expectedPosition = 2;
		final int maxPosition = cars.getMaxPosition();
		assertEquals(expectedPosition, maxPosition);
	}

	@Test
	void getMaxPositionInEmptyCars() {
		Cars cars = new Cars(new ArrayList<>());
		assertThatIllegalArgumentException().isThrownBy(cars::getMaxPosition)
			.withMessage("차가 존재하지 않습니다.");
	}
}
