package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.InputUtils;
import racingcar.utils.InputValidator;

public class InputUtilsTest {

    @DisplayName("Test for input value splited normally")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "pobi:1", "pobi,jinhwan:2"}, delimiter = ':')
    void splitSizeTest(String input, int cnt) {
        String[] names = InputUtils.splitNames(input);
        assertThat(names.length).isEqualTo(cnt);
    }

    @DisplayName("Test for input value splited normally")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void splitAllNameTest(String name) {
        String nameString = "pobi,crong,honux";
        String[] names = InputUtils.splitNames(nameString);
        assertThat(Arrays.asList(names).contains(name)).isTrue();
    }

    @DisplayName("Test for a valid name length")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "123", "1234", "12345"})
    void checkLengthTest(String name) {
        InputValidator.checkValidName(name);
    }

    @DisplayName("Exception test for null name")
    @Test
    void checkNullExceptionTest() {
        assertThatThrownBy(() -> {
            InputValidator.checkValidName(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exception test for over name length limit")
    @ParameterizedTest
    @ValueSource(strings = {"", "    ", "123456"})
    void checkLengthExceptionTest(String name) {
        assertThatThrownBy(() -> {
            InputValidator.checkValidName(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exception test for over duplicated name")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi, pobi"})
    void checkDuplicatedExceptionTest(String nameString) {
        assertThatThrownBy(() -> {
            String[] names = InputUtils.splitNames(nameString);
            InputValidator.isDuplicatedNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exception test for invalid tryCount")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "not_numeric"})
    void checkIsValidTryCount(String inputNumber) {
        assertThatThrownBy(() -> {
            InputValidator.isValidTryCount(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Test for valid tryCount")
    @ParameterizedTest
    @CsvSource(value = {"1 : 1", "23 : 23"}, delimiter = ':' )
    void checkIsValidTryCount(String inputNumber, int i) {
        assertThat(InputValidator.isValidTryCount(inputNumber))
            .isEqualTo(i);
    }
}
