package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PositiveNumbersTest {
    private static Stream<Arguments> positiveAndNumberValidationProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList("-1", "1"), IllegalArgumentException.class, "%d는 음수입니다.", -1),
                Arguments.of(Arrays.asList("1", "d"), IllegalArgumentException.class, "%s는 숫자가 아닙니다.", "d")
        );
    }

    @DisplayName("String 리스트를 입력하면 모두 더해서 반환하는지 테스트")
    @Test
    void addTest() {
        PositiveNumbers numbers = new PositiveNumbers(Arrays.asList("1", "2", "3"));
        assertThat(numbers.getSum()).isEqualTo(6);
    }

    @DisplayName("음수, 숫자가 아닌 문자가 들어오면 exception 발생")
    @ParameterizedTest
    @MethodSource("positiveAndNumberValidationProvider")
    void positiveValidationTest(List<String> maybeNumbers, Class aClass, String message, Object causeArgument) {
        assertThatThrownBy(() -> new PositiveNumbers(maybeNumbers))
                .isInstanceOf(aClass)
                .hasMessage(message, causeArgument);
    }
}