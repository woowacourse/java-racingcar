package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @DisplayName("기본 구분자 테스트")
    @CsvSource(value = {"1,2=3", "0,1=1", "1,2:3=6"}, delimiter = '=')
    void separatorTest(String input, Integer expected) {
        assertThat(stringCalculator.stringSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자 테스트: CsvSource 사용")
    @MethodSource("provideCustomSeparatorTestCase")
    void customSeparatorTest(String input, Integer expected) {
        assertThat(stringCalculator.stringSum(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideCustomSeparatorTestCase() {
        return Stream.of(
                Arguments.of("//c\n1,2", 3),
                Arguments.of("//c\n1,2,3", 6),
                Arguments.of("//c\n2,5", 7),
                Arguments.of("//-\n2,5:1", 8)
        );
    }

    @ParameterizedTest
    @DisplayName("빈문자열, null 입력 테스트")
    @MethodSource("provideNullAndEmptyTestCase")
    void emptyOrNullCaseTest(String input, Integer expected) {
        assertThat(stringCalculator.stringSum(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideNullAndEmptyTestCase() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of(null, 0),
                Arguments.of("1", 1)
        );
    }

    @ParameterizedTest
    @DisplayName("음수 입력 테스트")
    @MethodSource("provideNegativeNumberTestCase")
    void negativeNumberCaseTest(String input) {
        assertThatThrownBy(() -> {
            stringCalculator.stringSum(input);
        }).isInstanceOf(RuntimeException.class);
    }

    private static Stream<Arguments> provideNegativeNumberTestCase() {
        return Stream.of(
                Arguments.of("-2"),
                Arguments.of("1,-2"),
                Arguments.of("1,-2:4,-5"),
                Arguments.of("//*\n-2"),
                Arguments.of("//*\n-2,2")
        );
    }
}
