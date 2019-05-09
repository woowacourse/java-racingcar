package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameCountTest {

    @Test
    void 게임횟수가_0개_이하면_예외발생하는지_검사() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new GameCount(0);
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new GameCount(-1);
        });
    }

    @Test
    void 게임횟수가_1개_이상이면_정상적으로_생성하는지_검사() {
        assertThat(new GameCount(2).getGameCount()).isEqualTo(2);
    }
}