package operation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationTest {

    private Operation operation;

    @BeforeEach
    void setUp() {
        operation = new Operation();
    }

    @Test
    void 계산() {
        assertThat(operation.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void 다항식_연산자_위치_및_문자열이_올_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            operation.calculate("+ 2 / 3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            operation.calculate("2 + @ + 3");
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            operation.calculate("3 + 2 *");
        });
    }

    @Test
    void 영으로_나눌_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            operation.calculate("2 / 0");
        });
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }
}
