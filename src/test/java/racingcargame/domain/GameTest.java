package racingcargame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    Game game;

    @BeforeEach
    void setUp() {
        game = new Game("car1,car2", 1);
    }

    @Test
    @DisplayName("레이스를 하면 시도 횟수가 감소하는지 테스트")
    void raceAndHasRaceCount() {
        assertThat(game.hasRaceCount()).isTrue();
        game.race();
        assertThat(game.hasRaceCount()).isFalse();
    }
}
