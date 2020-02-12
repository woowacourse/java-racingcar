package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAdditionCalculatorTest {
    @Test
    void addTest() {
        //given
        StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int expected = 15;
        //when
        int result = stringAdditionCalculator.calculate(numbers);
        //then
        assertThat(result).isEqualTo(expected);
    }
}
