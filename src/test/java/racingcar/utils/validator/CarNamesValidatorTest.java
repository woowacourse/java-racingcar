package racingcar.utils.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNamesValidatorTest {

    @Test
    @DisplayName("자동차 이름에 null이 들어오는 경우 에러 발생 테스트")
    void validateCarNamesNull() {
        String[] carNames = {null};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 빈값이 들어오는 경우 에러 발생 테스트")
    void validateCarNamesEmpty() {
        String[] carNames = {"aa", "", "cc"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 들어오는 경우 에러 발생 테스트")
    void validateCarNamesBlank() {
        String[] carNames = {"aa", " ", "cc"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 공백이 될 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과일 경우 에러 발생 테스트")
    void validateCarNamesLength() {
        String[] carNames = {"aa", "bb", "cccccc"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("자동차 이름이 중복되는 경우 에러 발생 테스트")
    void validateCarNamesDuplicate() {
        String[] carNames = {"aa", "bb", "aa"};
        assertThatThrownBy(() -> {
            CarNamesValidator.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차 이름은 중복될 수 없습니다.");
    }
}
