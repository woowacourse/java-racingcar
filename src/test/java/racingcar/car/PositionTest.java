package racingcar.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Position;

public class PositionTest {

    @ParameterizedTest
    @DisplayName("정상적인 위치 입력")
    @ValueSource(ints = {0, 1, 5})
    void valueOfTest_정상_입력(int position) {
        assertThatCode(() -> {
            Position.valueOf(position);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("범위 밖의 위치 입력 시 예외 처리")
    @ValueSource(ints = {-1, -2, -3})
    void valueOfTest_범위_밖(int position) {
        assertThatThrownBy(() -> {
            Position.valueOf(position);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("존재할 수 없는 위치입니다.");
    }
}
