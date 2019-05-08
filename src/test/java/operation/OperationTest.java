package operation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {
    Operation op;

    @BeforeEach
    void setUp() {
        op = new Operation();
    }

    @Test
    void 계산() {
        assertThat(op.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @AfterEach
    void tearDown() {
        op = null;
    }
}
