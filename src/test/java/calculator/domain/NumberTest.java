package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("Number 만들기")
    public void makeNumberTest() {
        Number number = new Number("4");
        assertThat(number.getNumber()).isEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 것을 입력했을 때")
    @ValueSource(strings = {"1a, 2c, 3), 4*, 5&, 6^"})
    public void notNumberIncludedTest(String actual) {
        assertThatThrownBy(() -> new Number(actual))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값");
    }

    @Test
    @DisplayName("음수를 입력했을 때")
    public void negativeIntIncludedTest() {
        assertThatThrownBy(() -> new Number("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수");
    }

    @Test
    @DisplayName("빈 값을 입력했을 때")
    public void emptyValueIncludedTest() {
        assertThatThrownBy(() -> new Number(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("빈 값");
    }
}
