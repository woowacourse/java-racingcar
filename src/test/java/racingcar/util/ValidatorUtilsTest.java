package racingcar.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validateNotBlank;
import static racingcar.util.ValidatorUtils.validateNotOverFiveCharacters;

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
