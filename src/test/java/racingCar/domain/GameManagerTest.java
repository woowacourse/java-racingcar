package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class GameManagerTest {
    @Test
    void play() {
        String input = "pobi,jason,cu";
        GameManager gameManager = new GameManager(input);
        gameManager.play();
        List<Player> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void isEmpty_ShouldReturnTrueWhenInputInvalidName() {
        String input = "abcabc"; // ""
        GameManager gameManager= new GameManager(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputVaildName() {
        String input = "abcac"; // "a"
        GameManager gameManager= new GameManager(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isFalse();
    }

    @Test
    void isEmpty_ShouldReturnFalseWhenInputDuplicatedNames() {
        String input = "abc,abc";
        GameManager gameManager = new GameManager(input);

        Assertions.assertThat(gameManager.isEmpty())
                .isTrue();
    }
}
