package racingcargame.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnsGeneratorTest {
    @Test
    void 횟수가_0보다_작을때_테스트() {
        assertThrows(IllegalArgumentException.class, ()-> TurnsGenerator.makeTurns("0"));
        assertThrows(IllegalArgumentException.class, ()-> TurnsGenerator.makeTurns("-1"));

    }
}
