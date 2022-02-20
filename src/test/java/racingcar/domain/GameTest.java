package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameTest {
    private Car forky;
    private Car kun;
    private Car pobi;
    private List<Car> cars;

    @BeforeEach
    public void initialize_cars() {
        forky = new Car("forky");
        kun = new Car("kun");
        pobi = new Car("pobi");
        cars = List.of(forky, kun, pobi);

        forky.move(true);
    }

    @Test
    @DisplayName("우승자가 한 명일 때 우승자 판정")
    public void getWinners_one_winner() {
        Game game = new Game(cars, 0);
        assertThat(game.getWinners())
                .containsExactly(forky);
    }

    @Test
    @DisplayName("우승자가 두 명일 때 우승자 판정")
    public void getWinners_two_winners() {
        kun.move(true);
        Game game = new Game(cars, 0);
        assertThat(game.getWinners())
                .containsExactlyInAnyOrder(forky, kun);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("진행 횟수에 따른 게임 종료 판단")
    public void isEnd_after_play(int count) {
        Game game = new Game(cars, count);
        for (int i = 0; i < count; i++) {
            game.play();
        }
        assertThat(game.isEnd()).isTrue();
    }
}
