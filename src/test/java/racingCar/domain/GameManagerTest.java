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
        Player player = new Player(new PlayerName("pobi"));
        player.play(new FixedNumberGenerator());
        Assertions.assertThat(player.getPosition()).isEqualTo(0);
    }

    @Test
    void getWinner() {
        Assertions.assertThat(gameManager.getWinners()).isEqualTo("pobi, jason, cu");
    }
}
