package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerNameTest {
    PlayerName playerName;

    @Test
    void nameLengthZero() {
        String nameLengthZero = "";
        Assertions.assertThatThrownBy(
                () -> {
                    new PlayerName(nameLengthZero);
                }
        );
    }

    @Test
    void nameLengthLargerThanFive() {
        String nameLengthLargerThanFive = "oversi";
        Assertions.assertThatThrownBy(
                () -> {
                    new PlayerName(nameLengthLargerThanFive);
                }
        );
    }
}
