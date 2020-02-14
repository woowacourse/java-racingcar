package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

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