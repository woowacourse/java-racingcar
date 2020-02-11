package application.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddCalculatorTest {
    private Calculate calculate;

    @BeforeEach
    public void setUp() {
        calculate = new Calculate();
    }

    @Test
    @DisplayName("구분자를 추출하는 기능 테스트")
    public void extractStringValue() {
        String[] input = {"//;\n1;2;3", "//;;\n1;;2;;3", "//'\n1'2'3"};
        String[] expected = {";", ";;", "'"};

        for (int i = 0; i < input.length; i++) {
            Assertions.assertThat(calculate.isSameDelimiter(input[i])).isFalse();
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
            calculate = new Calculate();
            Assertions.assertThat(calculate.extractExpression(input[i])).isEqualTo(lists.get(i));
        }
    }

    @Test
    @DisplayName("커스텀 구분자를 추가하는 테스트")
    public void addCustomDelimiterTest() {
        String input = "//;\n1,2:3;4";
        calculate.extractDelimiter(input);
        Assertions.assertThat(calculate.isSameDelimiter(",|:|;")).isTrue();
    }

    @Test
    @DisplayName("숫자 이외의 값 또는 음수가 입력되면 RuntimeException throw")
    public void runtimeException_throw() {
        String[] inputs = {"a,1", "-1,1", "1,3p4"};
        for (String input : inputs) {
            Assertions.assertThatThrownBy(() -> {
                calculate.extractExpression(input);
            }).isInstanceOf(RuntimeException.class);
        }
    }

    @Test
    @DisplayName("올바르지 않은 커스텀 구분자 문자열 테스트")
    public void checkCustomExpressionTest() {
        String[] inputs = {"/;\n1;2;3;", ";\n1,2,3", " ;\n1;2;3", "//;1;2;3"};
        for (String input : inputs) {
            Assertions.assertThatThrownBy(() -> {
                calculate.checkCustomExpression(input);
            }).isInstanceOf(RuntimeException.class);
        }
    }
}
