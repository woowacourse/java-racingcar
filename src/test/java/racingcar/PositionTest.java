package racingcar;

import javafx.geometry.Pos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;

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
                .hasMessage("car의 position이 범위를 벗어났습니다.");
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
                .hasMessage("car의 position이 범위를 벗어났습니다.");
    }
}
