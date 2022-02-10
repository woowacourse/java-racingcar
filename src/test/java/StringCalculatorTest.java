
import StringCalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    @Test
    @DisplayName("정수 파라미터 두개를 더해서 반환한다.")
    void add() {
        StringCalculator stringCalculator = new StringCalculator();
        int actual = stringCalculator.calculate("//;\n1;2;3");
        int expected = 6;
        assertThat(actual).isEqualTo(expected);
    }
}
