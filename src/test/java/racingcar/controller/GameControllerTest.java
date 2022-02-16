package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAsciiCharaters")
public class GameControllerTest {
    @Test
    void null로_생성되는경우_예외발생() {
        assertThatThrownBy(() -> new GameController(null)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null은 사용할 수 없습니다. MoveStrategy타입을 사용하세요.");
    }
}
