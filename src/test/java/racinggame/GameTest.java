package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    Game game;
    CarsName carsName;
    Cars cars;
    int maxInstance;
    Winner winner;

    @BeforeEach
    void setUp() {
        game = new Game();
        carsName = new CarsName("pobi, honux, crong");
        cars = new Cars(carsName);
        maxInstance = 2;
    }

    @Test
    void 게임_플레이_후_위너_반환_테스트() {
        winner = game.playGames(cars, maxInstance);
        boolean result = winner.getWinners().isEmpty();
        assertThat(result).isEqualTo(false);
    }
}
