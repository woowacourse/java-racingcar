package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("불변 객체 테스트")
    public void check_construct(int position) {
        assertThat(new Position(position)).isEqualTo(new Position(position));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    @DisplayName("거리가 0보다 작을 경우 예외처리 테스트")
    public void check_position_exception(int position) {
        assertThatThrownBy(() -> new Position(position))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[Error] 거리는 0보다 커야합니다.");
    }

}
