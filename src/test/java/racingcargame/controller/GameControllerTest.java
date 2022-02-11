package racingcargame.controller;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import racingcargame.utils.NameInputValidator;

public class GameControllerTest {

    @Test
    void 자동차_이름_공백_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주할 자동차 이름을 입력해주세요.");
    }

    @Test
    void 자동차_이름_빈칸_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("pii, ,doo");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.");
    }

    @Test
    void 자동차_이름_5자초과_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("pii,kikiee,doo");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.");
    }

    @Test
    void 중복된_자동차_이름_입력_예외_테스트() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("gl,gl");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 중복된 자동차 이름이 있습니다.");
    }
}