package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNameTest {
    @Test
    void PlayerName_ToStringShouldReturnSameString() {
        String input = "Abccc";
        PlayerName playerName = new PlayerName(input);

        Assertions.assertThat(playerName.toString())
                .isEqualTo(input);
    }

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