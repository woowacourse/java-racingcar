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
    void play_Once() {
        gameManager.play(1).forEach(System.out::println);
        List<PlayerInfoPair> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void play_Multiple() {
        gameManager.play(3).forEach(System.out::println);
        List<PlayerInfoPair> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void name() {
        List<String> winnerList = gameManager.getWinner();
        System.out.println(winnerList);
    }
}
