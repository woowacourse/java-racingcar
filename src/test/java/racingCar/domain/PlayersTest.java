package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class PlayersTest {
    @Test
    void play() {
        String input = "pobi,jason,cu";
        Players gameManager = new Players(input);
        gameManager.play();
        List<Player> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef"})
    void isEmpty_ShouldReturnTrueWhenInputInvalidName(String input) {
        Players gameManager= new Players(input);
        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputVaildName() {
        String input = "abcac"; // "a"
        Players gameManager= new Players(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isFalse();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputDuplicatedNames() {
        String input = "abc,abc";
        Players gameManager = new Players(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }
}
