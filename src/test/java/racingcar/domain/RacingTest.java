package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
	private Racing racing;

	@BeforeEach
	void setUp() {
		final String[] cars = new String[] {"잉", "매트", "소니"};
		final String count = "3";
		racing = new Racing(cars, count);

		for(int i = 0; i < 3; i++) {
			racing.race();
		}
	}

	@DisplayName("횟수에 맞게 경주가 이뤄지는지 확인")
	@Test
	void isEnd() {
		assertThat(racing.isEnd()).isTrue();
	}

	@DisplayName("우승자가 알맞게 나오는지 확인")
	@Test
	void getWinners() {
		// 우승자 리스트를 예상하는 시나리오를 짜서 그거대로 나오는 지 테스트해야 한다
			// maxPosition을 구해서 나온 max값과 우승자 포지션을 비교하는 방법으로....
		// 근데 내가 그걸 어케 알지 ?


		List<String> winners = racing.getWinners();
		System.out.println(winners);
	}
}
