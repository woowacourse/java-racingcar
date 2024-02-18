package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @DisplayName("이동 횟수가 1 미만 숫자인 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100000"})
    void exceptionInvalidCountInput(int given) {
        //when //then
        assertThatThrownBy(() -> new TryCount(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("TryCount가 ")
                .hasMessageContaining("보다 작은 숫자가 입력되었습니다. 입력값 : ");
    }
}
