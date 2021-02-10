package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidNumOfMoveException;

class PositionTest {

    @Test
    public void 생성_및_비교() {
        Position position1 = Position.of(1);
        Position position2 = Position.of(1);

        assertThat(position1).isEqualTo(position2);
    }

    @DisplayName("Position(시도 횟수)의 값 음수 예외처리 테스트")
    @Test
    public void 유효성_검사() {
        assertThatThrownBy(() -> Position.of(-1))
            .isInstanceOf(InvalidNumOfMoveException.class);
    }

}