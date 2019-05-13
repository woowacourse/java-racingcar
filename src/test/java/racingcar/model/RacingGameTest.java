package racingcar.model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameTest {

    @Test
    void 자동차_이름_중복있는_경우_검사() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame("a,a".split(",")));
    }

    @Test
    void 올바르지_않은_시도횟수_검사() {
        assertThrows(IllegalArgumentException.class, () -> new RacingGame("a,b".split(","), "-1"));
    }
}
