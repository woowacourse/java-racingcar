package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    @Test
    void 앞에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames(",,,pobi"),1);
        });
    }

    @Test
    void 중간에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames("po,,,bi"),1);
        });
    }

    @Test
    void 뒤에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames("pobi,,,"),1);
        });
    }

    @Test
    void 공백이_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames("pobi,   ,brown"),1);
        });
    }

    @Test
    void 자동차들이_없는_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames(""),1);
        });
    }

    @Test
    void 시도_횟수가_최소값_미만인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(CarNameSpliter.splitCarNames("pobi,cu,brown"),-1);
        });
    }
}
