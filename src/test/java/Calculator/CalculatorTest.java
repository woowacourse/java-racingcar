package Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        List<String> testList = new ArrayList<>();
        testList.add("2");
        testList.add("+");
        testList.add("3");
        List<Integer> checkList = new ArrayList<>();
        checkList.add(2);
        checkList.add(3);
        assertThat(cal.extractNumbers(testList)).isEqualTo(checkList);
    }

}
