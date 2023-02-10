package validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    @ParameterizedTest(name = "carName : {0}")
    @NullAndEmptySource
    @DisplayName("자동차 이름 입력이 비어있는 경우 예외처리")
    void validateNullAndEmpty(String carName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(carName));
    }

    @Test
    @DisplayName("자동차 이름의 길이 범위 초과 시 예외처리")
    void validateOutOfLength() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate("dddddd"));
    }

    @ParameterizedTest(name = "carName : {0}")
    @ValueSource(strings = {"aa, b,cc", "aa,b ,cc"})
    @DisplayName("이름에는 공백을 입력 시 예외처리")
    void validateOutOfRange(String carName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> CarNameValidator.validate(carName));
    }
}