package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Car forky;
    private Car kun;
    private Car pobi;
    private Cars cars;

    @BeforeEach
    public void initialize_cars() {
        forky = new Car("forky");
        kun = new Car("kun");
        pobi = new Car("pobi");
        cars = new Cars(List.of(forky, kun, pobi));

        forky.move(true);
    }

    @Test
    @DisplayName("우승자가 한 명일 때 우승자 판정")
    public void getWinners_one_winner() {
        Game game = new Game(cars);
        assertThat(game.getWinners())
                .containsExactly(forky);
    }

    @Test
    @DisplayName("우승자가 두 명일 때 우승자 판정")
    public void getWinners_two_winners() {
        kun.move(true);
        Game game = new Game(cars);
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder(forky, kun);
    }
}
