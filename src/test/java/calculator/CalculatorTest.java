package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
    }

    @Test
    void 타입을_제대로_변경하는지_확인() {
        List<String> testList = Arrays.asList("2", "+", "3");
        List<Integer> checkList = Arrays.asList(2, 3);
        assertThat(cal.extractNumbers(testList)).isEqualTo(checkList);
    }

    @Test
    void 기호만_따로_잘분리_하는지_확인() {
        List<String> testList = Arrays.asList("2", "+", "3");
        List<String> checkList = Arrays.asList("+");
        assertThat(cal.extractSymbols(testList)).isEqualTo(checkList);
    }

    @Test
    void 결과값을_제대로_반환하는지_확인() {
        List<Integer> testList = Arrays.asList(2, 3);
        List<String> checkList = Arrays.asList("+");
        assertThat(cal.calculate(testList, checkList)).isEqualTo(5);
    }

    @Test
    void 결과값을_enum을_통해_반환하는지_확인() {
        assertThat(Calculate.RESULT.getCalculateResult(2, 3, "+")).isEqualTo(5);
    }

}
