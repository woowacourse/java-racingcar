package racingcargame.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceCountTest {

	@DisplayName("경주횟수가 정상적으로 저장되는지 테스트")
	@Test
	void createObject_RaceCount() {
		RaceCount raceCount = new RaceCount(7);

		assertThat(raceCount.getCount()).isEqualTo(7);
	}
}
