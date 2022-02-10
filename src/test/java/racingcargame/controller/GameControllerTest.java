package racingcargame.controller;

import org.junit.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameControllerTest {
    GameController gameController = new GameController();

    @Test
    void 자동차_이름_공백_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            gameController.inputCarName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름이 없습니다.");
    }
}