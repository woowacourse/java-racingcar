package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    Calculator cal;

    @BeforeEach
    void setup(){
        cal = new Calculator();
    }

    @Test
    void extractNumbersTest() {
        List<String> testList = Arrays.asList("2", "+", "3");
        List<Integer> checkList = Arrays.asList(2,3);
        assertThat(cal.extractNumbers(testList)).isEqualTo(checkList);
    }

    @Test
    void extractSymbolsTest() {
        List<String> testList = Arrays.asList("2", "+", "3");
        List<String> checkList = Arrays.asList("+");
        assertThat(cal.extractSymbols(testList)).isEqualTo(checkList);
    }

    @Test
    void calculateTest(){
        List<Integer> testList = Arrays.asList(2,3);
        List<String> checkList = Arrays.asList("+");
        assertThat(cal.calculate(testList, checkList)).isEqualTo(5);
    }

    @Test
    void innerCalculateTest(){
        assertThat(cal.innerCalculate(2, 3, "+")).isEqualTo(5);
    }

}
