package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameManagerTest {
    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        String input = "pobi,jason,cu";
        gameManager = new GameManager(input);
    }

    @Test
    void play() {
        gameManager.play();
        List<Player> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void getWinner() {
        System.out.println(gameManager.getWinners());
    }
}
