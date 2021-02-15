package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

public class InputUtilsTest {

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
            InputUtils.isOnlyNumber(inputNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Exception test for duplicated name")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi, pobi"})
    void checkDuplicatedExceptionTest(String nameString) {
        assertThatThrownBy(() -> {
            String[] names = InputUtils.splitNames(nameString);
            Cars.createByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
