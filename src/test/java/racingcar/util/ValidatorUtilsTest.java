package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.util.ValidatorUtils.splitAndValidateCarNames;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class ValidatorUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10"})
    void validateAndParsePositiveInt_returnParsedPositiveInteger(String string) {
        int parsedInt = validateAndParsePositiveInt(string);

        assertThat(parsedInt).isPositive();
    }

    @ParameterizedTest
    @ValueSource(strings = {"한글", "eng", "$", "1.0"})
    void validateAndParsePositiveInt_errorOnNonInteger(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void validateAndParsePositiveInt_errorOnNonPositiveInteger(String string) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> validateAndParsePositiveInt(string))
                .withMessageMatching("양수를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,b,jeong", "#,$%^&*", "roma,b d", "1  2,c,d"})
    void splitAndValidateCarNames_returnStringArrayOnPass(String carNamesString) {
        String[] carNames = splitAndValidateCarNames(carNamesString);
        assertThat(carNames).isEqualTo(carNamesString.split(","));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",a"," ,b", "   ,c,d"})
    void splitAndValidateCarNames_errorOnBlank(String carNamesString) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching("공백을 입력하면 안 됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456,a,b", "carrots,c,d"})
    void splitAndValidateCarNames_errorOnOverFiveCharacters(String carNamesString) {

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching("5글자 이하의 이름을 입력해야 합니다.");
    }

    @Test
    void splitAndValidateCarNames_errorOnDuplicates() {
        String carNamesString = "aa,aa,b";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> splitAndValidateCarNames(carNamesString))
                .withMessageMatching("중복된 이름을 입력하면 안 됩니다.");
    }
}
