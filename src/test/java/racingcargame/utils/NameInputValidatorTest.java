package racingcargame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameInputValidatorTest {

    @Test
    @DisplayName("자동차 이름 null 입력 시 예외")
    void inputNullCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주할 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름 공백 입력 시 예외")
    void inputBlankCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("pii, ,doo");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과한 경우 예외")
    void exceedCarNameLimitSize() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("pii,kikiee,doo");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 자동차 이름을 1자이상, 5자 이하로 입력해주세요.");
    }

    @Test
    @DisplayName("중복된 자동차 이름 입력 시 예외")
    void inputSameCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNames("lawn,lawn");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 중복된 자동차 이름이 있습니다.");
    }
}