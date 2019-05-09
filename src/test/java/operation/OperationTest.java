package operation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperationTest {

    Operation operation;

    @BeforeEach
    void setUp() {
        operation = new Operation();
    }

    @Test
    void 계산() {
        assertThat(operation.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @AfterEach
    void tearDown() {
        operation = null;
    }
}
