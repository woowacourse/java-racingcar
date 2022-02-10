package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
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
}
