package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {
    StringBuilder carNames = new StringBuilder();

    @BeforeEach
    void setUp() {
        carNames.append("pobi,dennis");
    }

    @Test
    void 차량이름_중복() {
        carNames.append(",pobi");
        assertThrows(IllegalArgumentException.class, () -> {
            new Racing(carNames.toString().split(","), 3);
        });
    }

    @Test()
    void 이동횟수_음수() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Racing(carNames.toString().split(","), -1);
        });
    }
}
