package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomIntegerGeneratorTest {

	@Test
	void 숫자_범위_테스트() {
		assertThat(RandomIntegerGenerator.random(3, 3)).isEqualTo(3);
		assertThat(RandomIntegerGenerator.random(0, 9)).isBetween(0, 9);
	}
}
