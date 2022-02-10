package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

public class ValidatorUtilsTest {

    @DisplayName("validatePositiveInt 메서드는 양수가 입력되었을 때 예외를 발생시키지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10})
    void validatePositiveInt_passesOnPositive(int integer) {
        assertThatNoException().isThrownBy(
                () -> validatePositiveInt(integer)
        );
    }

    @DisplayName("validatePositiveInt 메서드는 음수 혹은 0이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-10, 0})
    void validatePositiveInt_errorOnNegativeAndZero(int integer) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validatePositiveInt(integer))
                .withMessageMatching("양수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void _validateNotBlank(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNotBlank(string))
                .withMessageMatching("공백을 입력하면 안 됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", "carrots"})
    void _validateNotOverFiveCharacters(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNotOverFiveCharacters(string))
                .withMessageMatching("5글자 이하의 이름을 입력해야 합니다.");
    }

    @Test
    void _validateNoDuplicates() {
        String[] carNames = new String[]{"aa", "aa", "b"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateNoDuplicates(carNames))
                .withMessageMatching("중복된 이름을 입력하면 안 됩니다.");
    }
}
