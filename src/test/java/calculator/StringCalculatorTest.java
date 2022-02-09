package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    void 콤마_구분자() {
        String[] actual = StringCalculator.splitString("1,2");
        String[] result = {"1", "2"};

        assertThat(actual).isEqualTo(result);
    }

}
