import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdditionCalculatorTest {
    private StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();

    @Test
    void addTest() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int expected = 15;
        //when
        int result = stringAdditionCalculator.calculate(numbers);
        //then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void createNumbersTest(int number) {
        //given
        String input = "1,2:3";
        String delimiter = ",|:";
        //then
        assertThat(stringAdditionCalculator.createNumbers(input, delimiter).contains(number)).isTrue();
    }

    @Test
    void getCustomDelimiterTest() {
        //given
        String expected = ";";
        String input = "\\" + expected + "\n1;2;3";
        // then
        assertThat(stringAdditionCalculator.getCustomDelimiter(input)).isEqualTo(expected);
    }

    @Test
    void hasCustomDelimiterTest() {
        //given
        String input = "\\,\n";
        //then
        assertThat(stringAdditionCalculator.hasCustomDelimiter(input)).isTrue();
    }

    @Test
    void validate() {
        //given
        final String isNotNumber = "-,3";
        final String delimiter = ",|:";
        //then
        assertThatThrownBy(() -> {
            stringAdditionCalculator.createNumbers(isNotNumber, delimiter);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Input has something not number");

        //given
        final String hasNegativeNumber = "1,-2:3";
        //then
        assertThatThrownBy(() -> {
            stringAdditionCalculator.createNumbers(hasNegativeNumber, delimiter);
        })
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Input has negative number");
    }
}
