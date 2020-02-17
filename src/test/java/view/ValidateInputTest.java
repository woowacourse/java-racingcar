package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateInputTest {

    @DisplayName("사용자 입력값의 유효성 검사")
    @ParameterizedTest
    @CsvSource(value = {"'car0,car1,,car2','2'", "'car0,car1,car2','()'", "'','3'"})
    void validateInput(String carNames, String round) {
        assertThatThrownBy(() -> ValidateInput.validateInput(carNames, round))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 자동차 값의 유효성 검사")
    @ParameterizedTest
    @CsvSource(value = {"'car1,,car'", "''"})
    void checkCarName(String carNames) {
        assertThatThrownBy(() -> ValidateInput.checkCarNames(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
