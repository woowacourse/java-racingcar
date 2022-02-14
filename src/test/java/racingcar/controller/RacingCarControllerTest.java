package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class RacingCarControllerTest {
	public RacingCarController racingCarController = new RacingCarController();

	@Test
	public void 자동차_이름_분리해서_가져오기_테스트() {
		List<String> carNames = racingCarController.getCarNames("이브,클레이,포비");
		assertThat(carNames.get(0)).isEqualTo("이브");
		assertThat(carNames.get(1)).isEqualTo("클레이");
		assertThat(carNames.get(2)).isEqualTo("포비");
	}
}