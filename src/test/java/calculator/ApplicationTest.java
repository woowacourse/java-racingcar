package calculator;

import calculator.domain.Delimiter;
import calculator.domain.Numbers;
import calculator.domain.StringAdditionCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Test
    void main() {
        String input = "//;\n1;2;3";
        int expected = 6;
        Delimiter delimiter = new Delimiter(input);

        Numbers numbers = new Numbers(input, delimiter.getDelimiter());

        StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();
        int result = stringAdditionCalculator.calculate(numbers.getNumbers());

        assertThat(result).isEqualTo(expected);
    }
}