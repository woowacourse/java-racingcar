package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMoveGeneratorTest {

    @Test
    @DisplayName("랜덤값을 생성하고 그 값에 따라 전진, 멈춤 여부를 받는다.")
    void getMovable() {
        RandomMoveGenerator generator = new RandomMoveGenerator();
        assertThat(generator.isMovable()).isInstanceOf(Boolean.class);
    }
}
