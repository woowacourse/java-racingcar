package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 스플릿() {
        String raw = "2 + 5";
        String[] strings = {"2", "+", "5"};
        String[] result = stringCalculator.splitString(raw);
        assertThat(result).isEqualTo(strings);
    }
}
