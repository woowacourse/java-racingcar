package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.service.RandomNumberMovingCondition;

public class CarsTest {
	@Test
	public void 자동차_이름_구분_및_저장() {
		Cars result = new Cars("배카라,아스피");
		assertThat(result).isEqualTo(new Cars(Arrays.asList(new Car("배카라", new RandomNumberMovingCondition()),
			new Car("아스피", new RandomNumberMovingCondition()))));
	}

	@Test
	public void 우승자_찾기() {
		Cars cars = new Cars(Arrays.asList(new Car("배카라", 4), new Car("아스피", 5), new Car("아놀드", 3)));
		List<String> result = cars.findWinnerCars();
		assertThat(result).isEqualTo(Arrays.asList("아스피"));
	}
}
