package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNameTest {
    @Test
    void PlayerName_ShouldThrowWhenInputIsGreaterThanFive() {
        String greaterThanFive = "abcdef";

        Assertions.assertThatThrownBy(() -> {
            PlayerName case2 = new PlayerName(greaterThanFive);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void PlayerName_ShouldThrowWhenInputIsBlank() {
        String blank = "";

        Assertions.assertThatThrownBy(() -> {
            PlayerName case1 = new PlayerName(blank);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}