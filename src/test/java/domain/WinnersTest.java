package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    private Winners winners;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(
                new Car("pobi", 2),
                new Car("crong", 3),
                new Car("honux", 1)
        );
        winners = new Winners(cars);
    }

    @Test
    void 최대_포지션_구하기() {
        assertThat(winners.getMaxPosition()).isEqualTo(3);
    }

    @Test
    void 우승자_이름_구하기() {
        assertThat(winners.getRaceWinners(winners.getMaxPosition())).isEqualTo("crong");
    }

    @AfterEach
    void tearDown() {
        cars = null;
        winners = null;
    }
}