import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdditionCalculatorTest {
    private StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();

    @Test
    void addTest() {
        //given
        String input = "1,2:3";
        int expected = 6;
        //when
        int result = stringAdditionCalculator.calculate(input);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createNumbersTest(int number) {
        //given
        String input = "1,2:3";
        //then
        assertThat(stringAdditionCalculator.createNumbers(input).contains(number)).isTrue();
    }
}
