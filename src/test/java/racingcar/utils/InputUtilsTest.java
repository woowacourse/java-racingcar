package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.validator.InputValidator;
import racingcar.validator.NameValidator;
import racingcar.validator.RoundValidator;

public class InputUtilsTest {

    @DisplayName("Test for input value split normally")
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "pobi:1", "pobi,jinhwan:2"}, delimiter = ':')
    void splitSizeTest(String input, int cnt) {
        String[] names = InputUtils.splitNames(input);
        assertThat(names.length).isEqualTo(cnt);
    }

    @DisplayName("Test for input value split normally")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void splitAllNameTest(String name) {
        String nameString = "pobi,crong,honux";
        String[] names = InputUtils.splitNames(nameString);
        assertThat(Arrays.asList(names).contains(name)).isTrue();
    }

    @DisplayName("Exception test for invalid round")
    @ParameterizedTest
    @ValueSource(strings = {"not_numeric"})
    void checkIsInteger(String inputNumber) {
        assertThatThrownBy(() -> {
            InputValidator.isOnlyNumber(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
