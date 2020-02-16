package stringCalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringAdditionCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"1,3e4", "1,2,3,4e10"}, delimiter = 'e')
    @DisplayName("더하기")
    void add(String inputs, int expected) {
        List<Integer> operands = Arrays.stream(inputs.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toUnmodifiableList());

        int result = StringAdditionCalculator.sum(operands);
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
