package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈 기능만 테스트")
    public void addTest() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        int result = Calculator.calculation(numbers);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열이 들어오면 쉼표로 구분하여 배열로 변환한다.")
    public void string_Split_Test() {
        String[] strArrays = calculator.splitString("1,2:3");
        String[] expected = {"1", "2", "3"};
        Assertions.assertThat(strArrays).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자를 추출하는 기능 테스트")
    public void extractStringValue() {
        String[] input = {"//;\n1;2;3", "//;;\n1;;2;;3", "//'\n1'2'3"};
        String[] expected = {";", ";;", "'"};
        for (int i = 0; i < input.length; i++) {
            Assertions.assertThat(calculator.extractDelimiter(input[i])).isEqualTo(expected[i]);
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 이용하여 숫자를 추출")
    public void calculateWithCustomDelimiter() {
        String[] input = {"//;\n1;2;3", "//;;\n1;;20;;3", "//'\n4'5'6"};
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList(Arrays.asList(1, 2, 3)));
        lists.add(new ArrayList(Arrays.asList(1, 20, 3)));
        lists.add(new ArrayList(Arrays.asList(4, 5, 6)));
        for (int i = 0; i < input.length; i++) {
            Assertions.assertThat(calculator.extractExpression(input[i])).isEqualTo(lists.get(i));
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 추가하는 테스트")
    public void addCustomDelimiterTest() {
        String input = "//;\n1,2:3;4";
        String customDelimiter = calculator.extractDelimiter(input);
        calculator.addDelimiter(customDelimiter);
        Assertions.assertThat(calculator.isSameDelimiter(",|:|;")).isTrue();
    }

}
