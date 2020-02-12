package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import calculator.domain.Delimiter;
import calculator.domain.Numbers;
import calculator.domain.StringAdditionCalculator;

class ApplicationTest {
    @Test
    void main() {
        //given
        String input = "//;\n1;2;3";
        int expected = 6;
        //when
        Delimiter delimiter = new Delimiter(input);

        Numbers numbers = new Numbers(input, delimiter.getDelimiter());

        StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();
        int result = stringAdditionCalculator.calculate(numbers.getNumbers());
        //then
        assertThat(result).isEqualTo(expected);
    }
}