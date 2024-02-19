package model;

import message.Exception;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private Car pobi;
    private Car left;

    @BeforeEach
    void setUp() {
        pobi = new Car("포비");
        left = new Car("왼손");
    }

    @Test
    @DisplayName("우승자를 알아 낼 수 있다.")
    void findWinner() {
        Game game = new Game(List.of(pobi, left));
        pobi.forward();
        left.stop();
        assertThat(game.findWinners()).isEqualTo(List.of(pobi));
    }

    @Test
    @DisplayName("공동 우승자를 알아 낼 수 있다")
    void findWinners() {
        Game game = new Game(List.of(pobi, left));
        pobi.forward();
        left.forward();
        assertThat(game.findWinners()).isEqualTo(List.of(pobi, left));
    }
}
