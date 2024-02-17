package racingcar.view.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    @Test
    @DisplayName("이름 사이에 공백이 존재하는 자동차 이름 테스트")
    void validateNameWithSpace() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAvailableNames(Arrays.asList("ca r","car1")));
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름 테스트")
    void validateLongName() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAvailableNames(Arrays.asList("longname", "car1")));
    }

    @Test
    @DisplayName("작명 규칙을 위반하지 않은 자동차 이름 테스트")
    void validateValidNames() {
        assertDoesNotThrow(() -> InputValidator.validateAvailableNames(Arrays.asList("car1", "car2")));
    }

    @Test
    @DisplayName("자동차가 한 대인지 테스트")
    void validateSingleName() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAvailableNames(Arrays.asList("car")));
    }

    @Test
    @DisplayName("중복되는 자동차 이름 테스트")
    void validateDuplicateNames() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateAvailableNames(Arrays.asList("car", "car")));
    }

    @Test
    @DisplayName("가능한 이름 목록 테스트")
    void validateAvailableCarNames() {
        assertDoesNotThrow(() -> InputValidator.validateAvailableNames(Arrays.asList("car1", "car2")));
    }

    @Test
    @DisplayName("시도 회수가 음수인지 테스트")
    void validateNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber("-1"));
    }

    @Test
    @DisplayName("시도 회수가 0인지 테스트")
    void validateZero() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber("0"));
    }

    @Test
    @DisplayName("가능한 시도 회수인지 테스트")
    void validateAvailableTryNumber() {
        assertDoesNotThrow(() -> InputValidator.validateTryNumber("5"));
    }

    @Test
    @DisplayName("숫자가 아닌 다른 문자가 횟수로 입력되었을 때 테스트")
    void validateNonNumeric() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber("five"));
    }
}
