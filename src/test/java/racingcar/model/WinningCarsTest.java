package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCarsTest {
    private WinningCars winningCars;

    @BeforeEach
    void setup() {
        Set<Car> testCar = new LinkedHashSet<>(Arrays.asList(new Car("a",1)
                , new Car("b",2), new Car("c",3)
                , new Car("d",4), new Car("e",5)));
        winningCars = new WinningCars(testCar);
    }

    @Test
    void 우승한_차의_이름들이_저장되는지_확인() {
        assertThat(winningCars.isWinner("e")).isTrue();
    }

    @Test
    void 우승하지_않은_차들의_이름들이_저장되지_않는지_확인() {
        assertThat(winningCars.isWinner("a")).isFalse();
        assertThat(winningCars.isWinner("b")).isFalse();
        assertThat(winningCars.isWinner("c")).isFalse();
        assertThat(winningCars.isWinner("d")).isFalse();
    }
}
