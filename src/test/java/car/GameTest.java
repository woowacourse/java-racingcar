package car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void 우승자를_판별한다() {
        Car car1 = new Car("땡칠", 0);
        Car car2 = new Car("물떡", 2);
        Car car3 = new Car("루쿠", 1);
        Game game = new Game(List.of(car1, car2, car3));

        assertThat(game.getWinners()).containsOnly(car2);
    }
}
