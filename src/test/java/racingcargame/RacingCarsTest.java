package racingcargame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.domain.RacingCars;

class RacingCarsTest {
	@Test
	@DisplayName("생성자를 통한 createCars 테스트")
	void constructorTest() {
		Assertions.assertThat(new RacingCars("pobi,cronx")).isInstanceOf(RacingCars.class);
	}

	@Test
	@DisplayName("생성자를 통한 createCars 실패 테스트")
	void constructorFailTest() {
		Assertions.assertThatThrownBy(() -> new RacingCars(RacingCars.DELIMITER))
			.hasMessage("구분자를 기준으로 이름을 입력해주세요.");
	}

	@Test
	@DisplayName("processOneRace 테스트")
	void processOneRaceTest() {
	}
}
