package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player("pobi");
    }

    @Test
    void move_Go() {
        int current, result;
        current = player.getPosition();
        player.play(true);
        result = player.getPosition();

        Assertions.assertThat(result - current).isEqualTo(1);
    }

    @Test
    void move_Stop() {
        int current, result;
        current = player.getPosition();
        player.play(false);
        result = player.getPosition();

        Assertions.assertThat(result - current).isEqualTo(0);
    }
}
