package racingcargame.controller;

import org.junit.jupiter.api.Test;
import racingcargame.utils.NameInputValidator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameControllerTest {
    InputController inputController = InputController.getInputController();

    @Test
    void 자동차_이름_공백_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름이 없습니다.");
    }

    @Test
    void 자동차_이름_빈칸_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("p, ,d");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름 중 이름이 없는 자동차가 있습니다.");
    }
}