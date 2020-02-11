import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 덧셈_쉼표_여러구분자() {
        int result = StringCalculator.add("1,2");
        assertThat(result).isEqualTo(3);

        result = StringCalculator.add("4,5");
        assertThat(result).isEqualTo(9);
    }
}
