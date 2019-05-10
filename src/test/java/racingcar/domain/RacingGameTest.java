package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {
    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 앞에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame.generateCarList(",,,pobi");
        });
    }

    @Test
    void 중간에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame.generateCarList("po,,,bi");
        });
    }

    @Test
    void 뒤에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame.generateCarList("pobi,,,");
        });
    }

    @Test
    void 공백이_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame.generateCarList("pobi,   ,brown");
        });
    }

    @Test
    void 시도_횟수가_최소값_미만인_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingGame.configureTryCount(-1);
        });
    }
}
