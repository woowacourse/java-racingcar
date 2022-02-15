package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.util.InputValidator;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidationTest {
    private final GameController gameController = new GameController();

    @Test
    @DisplayName("자동차명 입력시 공백이 들어간 경우")
    void inputSpaceBetweenCarNames() {
        final String actual = "bom, sun";
        final List<String> expected = Arrays.asList("bom", "sun");
        assertThat(gameController.splitCars(actual)).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름이 하나도 존재하지 않을 경우 예외처리")
    void blankInputException() {
        assertThatThrownBy(() -> gameController.splitCars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 중복이 존재하는 경우 예외처리")
    void duplicateCarNamesException() {
        assertThatThrownBy(() -> gameController.splitCars("aaa,bbb,aaa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상인 경우 예외처리")
    void exceededMaxCarNameLengthException() {
        assertThatThrownBy(() -> InputValidator.validateCarName(Arrays.asList("asd","qwerty")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있는 경우 예외처")
    void minimumCarNameLengthException() {
        assertThatThrownBy(() -> InputValidator.validateCarName(Arrays.asList("asd","qwerty")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
