package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCarsTest {
    private WinningCars winningCars = new WinningCars();

    @BeforeEach
    void setup() {
        Set<Car> testCars = new LinkedHashSet<>(Arrays.asList(
                new Car("d", 4), new Car("e", 5)));
        winningCars.setWinner(testCars);
    }

    @Test
    void 우승한_차의_이름들이_저장되는지_확인() {
        assertThat(winningCars.isWinner("e")).isTrue();
    }

    @Test
    void 우승하지_않은_차들의_이름들이_저장되지_않는지_확인() {
        assertThat(winningCars.isWinner("d")).isFalse();
    }
}
