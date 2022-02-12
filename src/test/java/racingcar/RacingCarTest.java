package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.GameTurn;

public class RacingCarTest {

	@Test
	public void 자동차_이름_공백() {
		assertThatThrownBy(() -> new Car(null))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_이름_null() {
		assertThatThrownBy(() -> new Car(""))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 자동차_이름_길이_제한_예외처리() {
		assertThatThrownBy(() -> new Car("배카라쿠네당"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_숫자_확인() {
		assertThatThrownBy(() -> new GameTurn("a"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	public void 횟수_양수_확인() {
		assertThatThrownBy(() -> new GameTurn("-1"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	// @Test
	// public void 자동차_객체_생성() throws Exception {
	// 	List<Car> result = racingCarGame.toCar(Arrays.asList("배카라", "아스피"));
	// 	assertThat(result).isEqualTo(Arrays.asList(new Car("배카라"), new Car("아스피")));
	// }

	@Test
	public void 전진_여부() {
		Car testCar = new Car("아스피", 2);
		testCar.move(4);
		assertThat(testCar.isSamePosition(new Car("배카라", 3))).isEqualTo(true);
	}

	@Test
	public void 남은_턴_확인() {
		GameTurn gameTurn = new GameTurn("1");
		boolean result = gameTurn.isPositive();
		assertThat(result).isEqualTo(true);
	}

	@Test
	public void 우승자_찾기() {
		Cars cars = new Cars(Arrays.asList(new Car("배카라", 4), new Car("아스피", 5), new Car("아놀드", 3)));
		List<String> result = cars.findWinnerCars();
		assertThat(result).isEqualTo(Arrays.asList("아스피"));
	}
}
