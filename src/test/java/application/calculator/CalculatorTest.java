package application.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CalculatorTest {
    private Calculate calculate;

    @BeforeEach
    public void setUp() {
        calculate = new Calculate();
    }

    @DisplayName("커스텀 구분자에서 개행 문자를 기준으로 계산식을 추출할 수 있는지 테스트")
    @Test
    public void substringTest() {
        String value = "//;\\n1,2,3";
        Assertions.assertThat(value.substring(value.indexOf("\\n") + 2)).isEqualTo("1,2,3");
    }

    @DisplayName("커스텀 구분자를 추가하는 테스트")
    @Test
    public void addCustomDelimiterTest() {
        String input = "//;\\n1,2:3;4";
        calculate.addCustomDelimiter(input);
        Assertions.assertThat(calculate.isSameDelimiter(",|:|;")).isTrue();
    }

    @DisplayName("구분자를 추출하는 기능 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "//;\\n1;2;3", "//;;\\n1;;2;;3", "//'\\n1'2'3"})
    public void extractDelimiterTest(String input) {
        calculate = new Calculate();
        String expected = calculate.extractDelimiter(input);
        calculate.addCustomDelimiter(input);
        Assertions.assertThat(calculate.isSameDelimiter(",|:" + expected)).isTrue();
    }

    @DisplayName("커스텀 구분자를 이용하여 숫자를 추출")
    @ParameterizedTest
    @ValueSource(strings = {"//;\\n1;2;3", "//;;\\n1;;2;;3", "//'\\n1'2'3", "1,2,3", "//;\\n1,2,3"})
    public void calculateWithCustomDelimiter(String input) {
        List<Integer> lists = new ArrayList(Arrays.asList(1, 2, 3));
        calculate = new Calculate();
        Assertions.assertThat(calculate.makeNumbersList(input)).isEqualTo(lists);
    }

    @DisplayName("숫자 이외의 값 또는 음수가 입력되면 RuntimeException throw")
    @ParameterizedTest
    @ValueSource(strings = {"a,1", "-1,1", "1,3p4"})
    public void throwRuntimeExceptionWhenNegativeNumberTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            calculate.makeNumbersList(input);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("올바르지 않은 커스텀 구분자 문자열 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"/;\\n1;2;3;", ";\\n1,2,3", " ;\\n1;2;3", "//;1;2;3"})
    public void checkCustomExpressionTest(String input) {
        Assertions.assertThatThrownBy(() -> {
            calculate.checkCustomExpression(input);
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<List<Integer>> provideListElementHasSameSum() {
        return Stream.of(new ArrayList(Arrays.asList(30)),
                new ArrayList(Arrays.asList(10, 10, 10)),
                new ArrayList(Arrays.asList(15, 15)),
                new ArrayList(Arrays.asList(3, 6, 6, 3, 12)));
    }

    @DisplayName("덧셈 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideListElementHasSameSum")
    public void calculationTest(List<Integer> list) {
        Assertions.assertThat(Calculate.calculation(list)).isEqualTo(30);
    }

}
