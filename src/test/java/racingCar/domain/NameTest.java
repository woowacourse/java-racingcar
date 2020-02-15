package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "bc", "def", "abcde"})
    void toString_ShouldReturnSameString(String input) {
        Name name = new Name(input);
        Assertions.assertThat(name.toString())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "notebook"})
    void playerName_ShouldThrowWhenInputIsGreaterThanFive(String input) {
        Assertions.assertThatThrownBy(() -> {
            Name name = new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void playerName_ShouldThrowWhenInputIsBlank() {
        String blank = "";
        Assertions.assertThatThrownBy(() -> {
            Name name = new Name(blank);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abcde"})
    void equals_ShouldReturnTrue(String input) {
        Name a = new Name(input);
        Name b = new Name(input);
        Assertions.assertThat(a.equals(b)).isTrue();
        Assertions.assertThat(b.equals(a)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"a,ab", "kueni,pobi", "dodo,sdf"})
    void equals_ShouldReturnFalse(String input1, String input2) {
        Name a = new Name(input1);
        Name b = new Name(input2);
        Assertions.assertThat(a.equals(b)).isFalse();
        Assertions.assertThat(b.equals(a)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"kueni", "pobi", "jason"})
    void getString(String string) {
        Name name = new Name(string);
        Assertions.assertThat(name.toString().equals(string))
                .isTrue();
    }
}