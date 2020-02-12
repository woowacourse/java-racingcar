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
    void move() {
        int current, result;
        current = player.getPosition();
        player.play();
        result = player.getPosition();
        List<Integer> expected = Arrays.asList(0,1);

        Assertions.assertThat(expected.contains(result - current)).isTrue();
    }
}
