package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @DisplayName("숫자가 아닌 것을 입력했을 때")
    @ValueSource(strings = {"1a, 2c, 3), 4*, 5&, 6^"})
    public void notNumberIncludedTest(String actual) {

        assertThatThrownBy(() -> new Number(actual))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값");
    }
}
