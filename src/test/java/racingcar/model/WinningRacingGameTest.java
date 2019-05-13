package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningRacingGameTest {
    WinningCars winningCars;

    @BeforeEach
    void setup() {
        winningCars = new WinningCars();
        Car car1 = new Car("a", 1);
        Car car2 = new Car("b", 2);
        Car car3 = new Car("c", 3);
        winningCars.addWinners(car1, 3);
        winningCars.addWinners(car2, 3);
        winningCars.addWinners(car3, 3);
    }

    @Test
    void 우승한_차의_이름들이_저장되는지_확인() {
        assertThat(winningCars.isWinner("c")).isTrue();
    }

    @Test
    void 우승하지_않은_차들의_이름들이_저장되지_않는지_확인() {
        assertThat(winningCars.isWinner("a")).isFalse();
        assertThat(winningCars.isWinner("b")).isFalse();
    }
}
