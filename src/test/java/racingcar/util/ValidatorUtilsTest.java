package racingcar.util;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_BLANK_OR_NULL_NOT_ALLOWED;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_OVER_FIVE_CHARACTERS;
import static racingcar.util.ValidatorUtils.validateCarName;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorUtilsTest {

    @DisplayName("validatePositiveInt 메서드는 입력된 숫자가 0이 아닌 양의 정수인지 검사한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {1, 2, 10})
    void validatePositiveInt_PositiveInteger(int integer) {
        assertThatNoException()
                .isThrownBy(() -> validatePositiveInt(integer));
    }

    @DisplayName("validatePositiveInt 메서드는 입력된 숫자가 0 또는 음의 정수일 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(ints = {0, -1})
    void validateAndParsePositiveInt_errorOnNonInteger(int integer) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validatePositiveInt(integer))
                .withMessageMatching(ERROR_NOT_POSITIVE_INTEGER);
    }

    @DisplayName("validateCarName 메서드는 문자열이 Car 이름으로 적합한지 검사한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"jeong", "$%^&*", " roma", "1  2"})
    void validateCarNames_returnStringArrayOnPass(String carName) {
        assertThatNoException()
                .isThrownBy(() -> validateCarName(carName));
    }

    @DisplayName("validateCarName 메서드는 null 혹은 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @NullAndEmptySource
    void validateCarNames_errorOnBlank(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateCarName(carName))
                .withMessageMatching(ERROR_BLANK_OR_NULL_NOT_ALLOWED);
    }

    @DisplayName("validateCarName 메서드는 5글자를 초과하는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456", "carrots"})
    void validateCarNames_errorOnOverFiveCharacters(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateCarName(carName))
                .withMessageMatching(ERROR_OVER_FIVE_CHARACTERS);
    }

    @DisplayName("validateNoDuplicates 메서드는 중복된 이름이 입력되었을 때 예외를 발생시킨다.")
    @Test
    void validateCarNames_errorOnDuplicates() {
        String carNamesString = "aa,aa,b";
        String[] carNames = carNamesString.split(",");

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateNoDuplicates(carNames))
                .withMessageMatching(ERROR_DUPLICATE_NAME);
    }
}
