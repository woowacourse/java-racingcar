package calculator;

import calculator.domain.StringCalculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 덧셈_기능을_테스트한다() {
        assertThat(stringCalculator.calculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void 뺄셈_기능을_테스트한다() {
        assertThat(stringCalculator.calculate("2 - 3")).isEqualTo(-1);
    }

    @Test
    void 곱셈_기능을_테스트한다() {
        assertThat(stringCalculator.calculate("2 * 3")).isEqualTo(6);
    }

    @Test
    void 나눗셈_기능을_테스트한다() {
        assertThat(stringCalculator.calculate("10 / 3")).isEqualTo(3);
    }

    @Test
    void 긴_문자열_수식을_테스트한다() {
        assertThat(stringCalculator.calculate("2 + 3 * 4 / 2 - 7")).isEqualTo(3);
    }

    @AfterEach
    void tearDown() {
        stringCalculator = null;
    }
}