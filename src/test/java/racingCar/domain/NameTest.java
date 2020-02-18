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
        // when
        Name name = new Name(input);

        // then
        Assertions.assertThat(name.toString())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "notebook"})
    void playerName_ShouldThrowWhenInputIsGreaterThanFive(String input) {
        // then
        Assertions.assertThatThrownBy(() -> {

            // when
            Name name = new Name(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void playerName_ShouldThrowWhenInputIsBlank() {
        // given
        String blank = "";

        // then
        Assertions.assertThatThrownBy(() -> {

            // when
            Name name = new Name(blank);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abcde"})
    void equals_ShouldReturnTrue(String input) {
        // given
        Name a = new Name(input);
        Name b = new Name(input);

        // when
        Boolean result1 = a.equals(b);
        Boolean result2 = b.equals(a);

        // then
        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"a,ab", "kueni,pobi", "dodo,sdf"})
    void equals_ShouldReturnFalse(String input1, String input2) {
        // given
        Name a = new Name(input1);
        Name b = new Name(input2);

        // when
        boolean result1 = a.equals(b);
        boolean result2 = b.equals(a);

        // then
        Assertions.assertThat(result1).isFalse();
        Assertions.assertThat(result2).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"kueni", "pobi", "jason"})
    void getString(String string) {
        // given
        Name name = new Name(string);

        // when
        String result = name.toString();

        // then
        Assertions.assertThat(result.equals(string))
                .isTrue();
    }

    @Test
    void equals() {
        // given
        String input = "kueni";
        Name a = new Name(input);
        Name b = new Name(input);

        // when
        boolean bool = a.equals(b);

        // then
        Assertions.assertThat(bool).isTrue();
    }
}