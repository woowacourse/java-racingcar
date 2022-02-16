package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.util.Random;

public class RandomTest {
    @Test
    @DisplayName("범위에 맞는 랜덤값 생성")
    public void generate_random_in_bound_1() {
        int bound = 1;
        assertThat(Random.makeRandomValue(bound) <= bound).isTrue();
    }
}
