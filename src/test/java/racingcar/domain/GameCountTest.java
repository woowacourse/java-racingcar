package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameCountTest {
    @Test
    void 시도_횟수가_기준치_미만일_때_예외가_발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameCount(0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new GameCount(-1);
        });
    }

    @Test
    void 시도_횟수가_기준치_이상일_때_정상적으로_객체를_생성하는지_테스트() {
        assertThat(new GameCount(2).getGameCount()).isEqualTo(2);
    }
}