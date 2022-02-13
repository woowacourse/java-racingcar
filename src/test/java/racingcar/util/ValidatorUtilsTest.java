package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static constants.TestConstants.PARAMETERIZED_TEST_DISPLAY_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static racingcar.constants.OutputMessages.ERROR_BLANK_NOT_ALLOWED;
import static racingcar.constants.OutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.OutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.OutputMessages.ERROR_OVER_FIVE_CHARACTERS;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;
import static racingcar.util.ValidatorUtils.validateCarName;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;

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

    @DisplayName("validateCarName 메서드는 문자열이 차 이름으로 적합한지 검사한다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"jeong", "$%^&*", " roma", "1  2"})
    void validateCarNames_returnStringArrayOnPass(String carName) {
        assertThatNoException()
                .isThrownBy(() -> validateCarName(carName));
    }

    @DisplayName("validateCarName 메서드는 공백 혹은 빈 문자열이 입력되었을 때 예외를 발생시킨다.")
    @ParameterizedTest(name = PARAMETERIZED_TEST_DISPLAY_FORMAT)
    @ValueSource(strings = {"", " ", "    "})
    void validateCarNames_errorOnBlank(String carName) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> validateCarName(carName))
                .withMessageMatching(ERROR_BLANK_NOT_ALLOWED);
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
