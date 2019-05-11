package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameSpliterTest {
    @Test
    void 앞에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameSpliter.splitCarNames(",,,pobi");
        });
    }

    @Test
    void 중간에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameSpliter.splitCarNames("po,,,bi");
        });
    }

    @Test
    void 뒤에_연속된_콤마가_입력된_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            CarNameSpliter.splitCarNames("pobi,,,");
        });
    }
}
