package validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfTryValidatorTest {

    @ParameterizedTest(name = "numberOfTry : {0}")
    @ValueSource(strings = {"dd", "ㄹ", " "})
    @DisplayName("시도 횟수 입력 시 숫자가 아닌 경우 예외처리")
    void validateNotNumeric(String numberOfTry) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberOfTryValidator.validate(numberOfTry));
    }

    @ParameterizedTest(name = "numberOfTry : {0}")
    @ValueSource(strings = {"-1", "0"})
    @DisplayName("시도 횟수의 범위를 벗어난 숫자 입력 시 예외처리")
    void validateOutOfRange(String numberOfTry) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberOfTryValidator.validate(numberOfTry));
    }

    @ParameterizedTest(name = "numberOfTry : {0}")
    @NullAndEmptySource
    @DisplayName("시도 횟수 입력이 비어있는 경우 예외처리")
    void validateNullAndEmpty(String numberOfTry) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> NumberOfTryValidator.validate(numberOfTry));
    }
}