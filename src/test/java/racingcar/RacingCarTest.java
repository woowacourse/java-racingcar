package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.List;
public class RacingCarTest {

	@Test
	public void 자동차_이름_분리해서_가져오기_테스트() {
		InputManager inputManager = new InputManager();
		List<String> carNames = inputManager.splitAndSaveCarNames("이브,클레이,포비");
		assertThat(carNames.get(0)).isEqualTo("이브");
		assertThat(carNames.get(1)).isEqualTo("클레이");
		assertThat(carNames.get(2)).isEqualTo("포비");
	}
}
