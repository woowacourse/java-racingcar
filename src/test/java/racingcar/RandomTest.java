package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.domain.Random;

public class RandomTest {
	@Test
	public void 랜덤값_부여_테스트() {
		int bound = 1;
		assertThat(Random.makeRandomValue(bound) <= bound).isTrue();
	}
}
