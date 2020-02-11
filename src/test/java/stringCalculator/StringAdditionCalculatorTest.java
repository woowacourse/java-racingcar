package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StringAdditionCalculatorTest {
    @Test
    @DisplayName("더하기")
    void add() {
        List<String> operands = Arrays.asList(new String[]{"1", "3"});
        int result = StringAdditionCalculator.sum(operands);
        Assertions.assertThat(result).isEqualTo(4);
    }
}
