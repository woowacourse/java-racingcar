package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    @Test
    void 자동차들이_없는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames(""), 1);
        });
    }

    @Test
    void 시도_횟수가_최소값_미만인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames("pobi,cu,brown"), -1);
        });
    }
}
