package racingcargame.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameInputValidatorTest {

    @Test
    @DisplayName("자동차 이름 null 입력 시 예외")
    void inputNullCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNamesInput(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 경주할 자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차 이름 공백 입력 시 예외")
    void inputBlankCarNameException() {
        assertThatThrownBy(() -> {
            NameInputValidator.validateCarNamesInput("pii, ,doo");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[error] 입력된 자동차 이름 중 이름이 입력되지 않는 자동차가 있습니다.");
    }
}