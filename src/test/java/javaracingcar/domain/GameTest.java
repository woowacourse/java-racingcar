package javaracingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    @Test
    void init_중복된이름() {
        List<String> carNames = Arrays.asList("a", "b", "c", "a");
        assertThatThrownBy(() -> Game.init(carNames, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 이름");
    }

    @Test
    void init_정상적인생성() {
        List<String> carNames = Arrays.asList("a", "b", "c", "d");
        int trial = 5;
        Game game = Game.init(carNames, trial);
        assertEquals(game.getCarNames(), carNames);
        assertEquals(game.getTrial(), trial);
    }
}