package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static racingcar.domain.Position.MINIMUM_VALUE_ERROR_MESSAGE;
import static racingcar.domain.Position.START;

public class PositionTest {
    @DisplayName("객체 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100})
    public void create_success(final int value) {
        assertThatCode(() -> Position.from(value))
                .doesNotThrowAnyException();
    }

    @DisplayName("음수이면 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    public void create_fail(final int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.from(value))
                .withMessageContaining(MINIMUM_VALUE_ERROR_MESSAGE);
    }

    @DisplayName("동등 비교")
    @Test
    public void equal() {
        final int value = 5;
        final Position position = Position.from(value);

        assertThat(position).isEqualTo(Position.from(value));
    }

    @DisplayName("크기 비교")
    @Test
    public void compareTo() {
        final Position bigPosition = Position.from(20);
        final Position smallPosition = Position.from(10);

        final int compareResult = bigPosition.compareTo(smallPosition);
        assertThat(compareResult).isEqualTo(1);
    }

    @DisplayName("위치 이동 성공")
    @Test
    public void move() {
        final Position movedPosition = START.move();
        final Position expected = Position.from(1);

        assertThat(movedPosition)
                .isEqualTo(expected);
    }
}
