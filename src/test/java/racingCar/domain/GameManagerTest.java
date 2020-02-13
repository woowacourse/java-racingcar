package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
        Map<String, Integer> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void play_Multiple() {
        gameManager.play(3).forEach(System.out::println);
        Map<String, Integer> players = gameManager.getState();
        Assertions.assertThat(players.size()).isEqualTo(3);
    }

    @Test
    void getWinner() {
        List<Player> winnerList = gameManager.getWinners();
        winnerList.forEach((t) -> System.out.println(t.getName()));
    }
}
