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
        player.play(true);
    }

    @Test
    void move_Stop() {
        int current, result;
        player.play(false);
    }
}
