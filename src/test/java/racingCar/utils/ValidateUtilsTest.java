package racingCar.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class ValidateUtilsTest {

    @DisplayName("시도횟수의 형식이 올바르지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"d"})
    @NullAndEmptySource
    void invalidRoundInput(String invalidInput) {
        assertThatThrownBy(() -> {
            ValidateUtils.numberedCount(invalidInput);
        }).isInstanceOf(RuntimeException.class);
    }

}