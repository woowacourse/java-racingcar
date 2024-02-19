package domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @DisplayName("자동차 위치가 음수가 아닐 경우 정상적으로 도메인이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 999})
    void createByValidNameLength(int position) {
        assertThatCode(() -> Position.from(position))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차 위치가 음수인 경우 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-999, -2, -1})
    void createByInvalidNameLength(int position) {
        assertThatThrownBy(() -> Position.from(position))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
