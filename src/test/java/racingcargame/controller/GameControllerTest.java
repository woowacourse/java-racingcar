package racingcargame.controller;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameControllerTest {
    InputController inputController = InputController.getInputController();

    @Test
    void 자동차_이름_공백_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            inputController.checkCarNames("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름이 없습니다.");
    }
}