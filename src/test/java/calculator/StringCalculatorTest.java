package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    // 테스트를 작성(테스트가 통과되지 않을 정도만)
    // 실제 코드 작성(작성한 테스트가 통과될 때 까지만)

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
        //1. 커스텀 구분자가 있을 때 구분자 배열 확인 : , custom
        //2. 커스텀 구분자가 없을 때 구분자 배열 확인 : ,
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

    @Test
    @DisplayName("커스텀 구분자 테스트")
    void customSeparatorTest() {
        String input = "//c\n1,2";
        assertThat(stringCalculator.stringSum(input)).isEqualTo(3);
    }
}
