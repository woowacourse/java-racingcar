package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NameTest {
    @Test
    void PlayerName_ToStringShouldReturnSameString() {
        String input = "Abccc";
        Name name = new Name(input);

        Assertions.assertThat(name.toString())
                .isEqualTo(input);
    }

    @Test
    void PlayerName_ShouldThrowWhenInputIsGreaterThanFive() {
        String greaterThanFive = "abcdef";

        Assertions.assertThatThrownBy(() -> {
            Name case2 = new Name(greaterThanFive);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void PlayerName_ShouldThrowWhenInputIsBlank() {
        String blank = "";

        Assertions.assertThatThrownBy(() -> {
            Name case1 = new Name(blank);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}