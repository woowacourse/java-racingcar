package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("pobi");
    }

    @Test // checkContinuousComma Test
    void 연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame = new RacingGame("po,,,bi");
        });
    }

    @Test //
    void 공백이_입력된_경우() {
        racingGame = new RacingGame("pobi,brown,p   ");
        assertThat(racingGame).isEqualTo(new RacingGame("pobi,brown,p"));
    }

    @Test
    void 시도_횟수가_최소값_미만인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame = new RacingGame("pobi,brown", -1);
        });
    }
}
