package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "bc", "def", "sample"})
    void toString_ShouldReturnSameString(String input) {
        Name name = new Name(input);
        Assertions.assertThat(name.toString())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "notebook"})
    void playerName_ShouldThrowWhenInputIsGreaterThanFive(String input) {
        Assertions.assertThatThrownBy(() -> {
            Name case2 = new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void playerName_ShouldThrowWhenInputIsBlank() {
        String blank = "";
        Assertions.assertThatThrownBy(() -> {
            Name case1 = new Name(blank);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}