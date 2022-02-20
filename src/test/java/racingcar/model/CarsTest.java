package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import racingcar.service.MovingCondition;
import racingcar.service.RandomNumberMovingCondition;

public class CarsTest {
	@Test
	public void 자동차_이름_구분_및_저장() {
		Cars result = new Cars("배카라,아스피");
		assertThat(result).isEqualTo(new Cars(Arrays.asList(new Car("배카라", 0, new RandomNumberMovingCondition()),
			new Car("아스피", 0, new RandomNumberMovingCondition()))));
	}

	@Test
	public void 전체_자동차들_움직임_테스트() {
		MovingCondition movingCondition1 = () -> true;
		MovingCondition movingCondition2 = () -> true;
		Cars cars = new Cars(Arrays.asList(new Car("배카라", 0, movingCondition1), new Car("아스피", 0, movingCondition2)));
		cars.moveCars();
		cars.getCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
	}

	@Test
	public void 현재_자동차들_위치_테스트() {
		Cars cars = new Cars(Arrays.asList(new Car("배카라", 1, new RandomNumberMovingCondition()),
			new Car("아스피", 2, new RandomNumberMovingCondition())));
		Map<String, Integer> carsRecentPosition = cars.getRecentPosition();
		assertThat(carsRecentPosition.get("배카라")).isEqualTo(1);
		assertThat(carsRecentPosition.get("아스피")).isEqualTo(2);
	}

	@Test
	public void 중복_이름_테스트() {
		assertThatThrownBy(() -> new Cars("아스피,아스피")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 우승자_찾기() {
		Cars cars = new Cars(Arrays.asList(new Car("배카라", 4, new RandomNumberMovingCondition()),
			new Car("아스피", 5, new RandomNumberMovingCondition()),
			new Car("아놀드", 3, new RandomNumberMovingCondition())));
		List<String> result = cars.findWinnerCars();
		assertThat(result).isEqualTo(Arrays.asList("아스피"));
	}
}
