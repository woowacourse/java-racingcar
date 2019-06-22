package racingcargame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnsTest {
    @Test
    void 횟수가_0보다_작을때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Turns("0"));
        assertThrows(IllegalArgumentException.class, () -> new Turns("-1"));
    }
}
