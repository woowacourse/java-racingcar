package racingcar.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racingcar.utils.validator.CarNamesValidator;

@SuppressWarnings("NonAsciiCharacters")
public class CarNamesValidatorTest {

    @Test
    void 자동차_이름_5자_초과() {
        String[] carNames = {"aa", "bb", "ccccccc"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 5자 미만이어야 합니다.");
    }

    @Test
    void 자동차_이름_중복() {
        String[] carNames = {"aa", "bb", "aa"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void 자동차_이름_공백() {
        String[] carNames = {"aa", "", "cc"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    void 자동차_이름_입력X() {
        String[] carNames = {""};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }
}
