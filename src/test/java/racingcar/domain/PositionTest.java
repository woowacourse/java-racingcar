package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.Position.INVALID_POSITION_ERROR;

class PositionTest {
    @DisplayName("음수인 정수 포지션이 입력됐을 때 검증 해주는지")
    @ParameterizedTest
    @ValueSource(ints = {-2, -5})
    void positionConstructor_NonPositiveIntegerPosition_throwIllegalArgumentException(int position) {
        assertThatThrownBy(() -> new Position(position)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_POSITION_ERROR);
    }
}