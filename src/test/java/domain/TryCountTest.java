package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "3", "4", "5"})
    @DisplayName("validate() : 시도 횟수는 2이상 10 이하이다.")
    void test_validate_success(int input) {
        // when & then
        TryCount tryCount = new TryCount(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "11", "12"})
    @DisplayName("validate() : 시도 횟수는 2이상 10 이하이다.")
    void test_validate_fail(int input) {
        // when & then
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("2 이상, 10 이하의 수를 입력해주세요.");
    }
}
