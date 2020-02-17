package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;

/**
 * 자동차 위치 테스트 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class PositionTest {
    @Test
    @DisplayName("생성자 테스트")
    void constructor() {
        Assertions.assertThat(new Position())
                .isInstanceOf(Position.class);
    }

    @ParameterizedTest
    @DisplayName("생성자에 범위를 벗어난 입력이 들어온 경우")
    @ValueSource(ints = {-1, 0, 102})
    void constructor_범위를_벗어난_경우(int position) {
        Assertions.assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car's position out of range(1,101)");
    }

    @Test
    @DisplayName("moveForward 테스트")
    void moveForward() {
        Position position = new Position();
        position.moveForward();
        Assertions.assertThat(position)
                .isEqualTo(new Position(2));
    }

    @Test
    @DisplayName("moveForward에서 최대 position을 넘어가는 경우")
    void moveForward_최대를_넘어가는_경우() {
        Position position = new Position(101);
        Assertions.assertThatThrownBy(() -> position.moveForward())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Car's position out of range(1,101)");
    }
}
