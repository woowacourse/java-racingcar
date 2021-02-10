package racingCar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


class ValidateUtilsTest {

    @DisplayName("경주하는 자동차는 2개 이상이어야 한다")
    @Test
    public void 자동차_갯수_2개_이상_negative() {
        // given, when
        String[] carNames = {"pobi"};

        // then
        assertThrows(RuntimeException.class, () -> {
            ValidateUtils.validateNumOfCarNames(carNames);
        });
    }

    @DisplayName("시도횟수의 형식이 올바르지 않은 경우")
    @ParameterizedTest
    @ValueSource(strings = {"d"})
    @NullAndEmptySource
    void invalidRoundInput(String invalidInput) {
        assertThatThrownBy(() -> {
            ValidateUtils.validateInteger(invalidInput);
        }).isInstanceOf(RuntimeException.class);
    }

}