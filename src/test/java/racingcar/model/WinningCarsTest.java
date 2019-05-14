package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningCarsTest {

    WinningCars winningCars;

    @BeforeEach
    void setup() {
        winningCars = new WinningCars(
                new LinkedHashSet<>(Arrays.asList(new Car("a", 1), new Car("b", 2), new Car("c", 3))));
    }

    @Test
    void winningCars에_있는_자동차_검증() {
        assertThat(winningCars.isWinner("c")).isTrue();
    }

    @Test
    void winningCars에_없는_자동차_검증() {
        assertThat(winningCars.isWinner("b")).isFalse();
    }
}
