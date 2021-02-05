package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        Cars.carAdd(new Car("car1"));
        Cars.carAdd(new Car("car2"));
        Cars.carAdd(new Car("car3"));
        Cars.getCars().get(1).move(4);
        Cars.getCars().get(2).move(4);
        game = new Game();
    }

    @Test
    void findMax() {
        assertThat(game.findMax()).isEqualTo(1);
    }

    @Test
    void bar() {
        assertThat(game.bar(3)).isEqualTo("---");
    }

    @Test
    void getWinners() {
        List<String> winners = game.getWinners(1);
        assertThat(winners.get(0)).isEqualTo("car2");
        assertThat(winners.get(1)).isEqualTo("car3");
    }
}
