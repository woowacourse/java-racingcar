package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.constants.OutputMessages.ERROR_BLANK_NOT_ALLOWED;
import static racingcar.constants.OutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.OutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.OutputMessages.ERROR_OVER_FIVE_CHARACTERS;
import static racingcar.constants.SystemConstants.COMMA;
import static racingcar.util.ValidatorUtils.splitAndValidateCarNames;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class ValidatorUtilsTest {

    @DisplayName("validateAndParsePositiveInt 메서드는 문자열을 양수로 변환하여 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"1", "2", "10"})
    void validateAndParsePositiveInt_returnParsedPositiveInteger(String string) {
        int parsedInt = validateAndParsePositiveInt(string);

        assertThat(parsedInt).isPositive();
    }

    @DisplayName("validateAndParsePositiveInt 메서드는 양수 이외의 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"한글", "eng", "$", "1.0"})
    void validateAndParsePositiveInt_errorOnNonInteger(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string));
    }

    @DisplayName("validateAndParsePositiveInt 메서드는 음수 혹은 0에 해당되는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"-1", "0"})
    void validateAndParsePositiveInt_errorOnNonPositiveInteger(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string))
                .withMessageMatching(ERROR_NOT_POSITIVE_INTEGER);
    }

    @DisplayName("splitAndValidateCarNames 메서드는 문자열을 쉼표를 기준으로 구분하여 반환한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"a,b,jeong", "#,$%^&*", "roma,b d", "1  2,c,d"})
    void splitAndValidateCarNames_returnStringArrayOnPass(String carNamesString) {
        String[] carNames = splitAndValidateCarNames(carNamesString);
        assertThat(carNames).isEqualTo(carNamesString.split(COMMA));
    }

    @DisplayName("splitAndValidateCarNames 메서드는 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"", ",a", " ,b", "   ,c,d"})
    void splitAndValidateCarNames_errorOnBlank(String carNamesString) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching(ERROR_BLANK_NOT_ALLOWED);
    }

    @DisplayName("splitAndValidateCarNames 메서드는 5글자를 초과하는 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"123456,a,b", "carrots,c,d"})
    void splitAndValidateCarNames_errorOnOverFiveCharacters(String carNamesString) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching(ERROR_OVER_FIVE_CHARACTERS);
    }

    @DisplayName("splitAndValidateCarNames 메서드는 중복된 이름이 입력되었을 때 예외를 발생시킨다.")
    @Test
    void splitAndValidateCarNames_errorOnDuplicates() {
        String carNamesString = "aa,aa,b";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching(ERROR_DUPLICATE_NAME);
    }

    @DisplayName("splitAndValidateCarNames 메서드는 null이 입력되었을 때 예외를 발생시킨다.")
    @Test
    void splitAndValidateCarNames_null() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> splitAndValidateCarNames(null));
    }
}
