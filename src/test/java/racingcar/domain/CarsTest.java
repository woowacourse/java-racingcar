package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public void 자동차_경주_실행_테스트_전진() {
		Cars cars = new Cars(new RacingCarController().getCarNames("이브,클레이,포비"));
		cars.executeCarRacing(new BoundedRandomNumberGenerator(9, 4));
		Map<String, Integer> result = cars.getRacingRecord();

		for (Integer position : result.values()) {
			assertThat(position).isEqualTo(1);
		}
	}

	@Test
	public void 자동차_경주_실행_테스트2_멈춤() {
		Cars cars = new Cars(new RacingCarController().getCarNames("이브,클레이,포비"));
		cars.executeCarRacing(new BoundedRandomNumberGenerator(3, 0));
		Map<String, Integer> result = cars.getRacingRecord();

		for (Integer position : result.values()) {
			assertThat(position).isEqualTo(0);
		}
	}

	@Test
	public void 최종_우승자_찾기_테스트() {
		Cars cars = new Cars(new RacingCarController().getCarNames("이브,클레이"));
		cars.executeCarRacing(new BoundedRandomNumberGenerator(9, 4));
		List<String> winners = cars.findWinners(new WinnerNames());

		assertThat(winners.size()).isEqualTo(2);
		assertThat(winners).contains("이브", "클레이");
	}
}
