package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.RacingCarController;
import racingcar.util.BoundedRandomNumberGenerator;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {
	@Test
	public void 자동차_생성_테스트() {
		Cars cars = new Cars(new RacingCarController().getCarNames("이브,클레이,포비"));
		assertThat(cars.getSize()).isEqualTo(3);
	}

	@Test
	public void 최종_우승자_찾기_테스트() {
		Cars cars = new Cars(Collections.emptyList());
		cars.addCar(new Car("이브"));
		cars.addCar(new Car("클레이"));
		cars.executeCarRacing(new BoundedRandomNumberGenerator(9, 4));
		cars.addCar(new Car("포비"));
		cars.executeCarRacing(new BoundedRandomNumberGenerator(3, 0));
		List<String> winners = cars.findWinners(new WinnerNames());

		assertThat(winners.size()).isEqualTo(2);
		assertThat(winners).contains("이브", "클레이");
	}
}
