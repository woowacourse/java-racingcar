package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    StringCalculator cal;

    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @Test
    void 올바른_전체_계산() throws Exception {
        String[] inputs = {"2", "+", "3", "*", "4", "/", "2"};
        assertThat(cal.calculateAll(inputs)).isEqualTo(10);
    }

    @Test
    void 잘못된_입력_개수() {
        assertThrows(IllegalArgumentException.class, () -> {
            String[] inputs = {"2", "+", "3", "*", "4", "/"};
            assertThat(cal.calculateAll(inputs)).isEqualTo(10);
        });
    }

    @Test
    void 잘못된_숫자로_계산() {
        assertThrows(NumberFormatException.class, () -> {
            String[] inputs = {"a", "+", "3", "*", "4", "/", "2"};
            assertThat(cal.calculateAll(inputs)).isEqualTo(10);
        });
    }

    @Test
    void 양수를_영으로_나눈_경우() {
        String[] inputs = {"2", "+", "3", "*", "4", "/", "0"};
        assertThat(cal.calculateAll(inputs)).isEqualTo(Double.POSITIVE_INFINITY);
    }

    @Test
    void 음수를_영으로_나눈_경우() {
        String[] inputs = {"2", "+", "3", "*", "-4", "/", "0"};
        assertThat(cal.calculateAll(inputs)).isEqualTo(Double.NEGATIVE_INFINITY);
    }

    @Test
    void 영를_영으로_나눈_경우() {
        String[] inputs = {"0", "/", "0"};
        assertThat(cal.calculateAll(inputs)).isEqualTo(Double.NaN);
    }

    @AfterEach
    void tearDown() {
    }
}