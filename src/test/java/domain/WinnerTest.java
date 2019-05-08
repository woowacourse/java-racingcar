package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {
    Winner winner;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("a");
        Car car2 = new Car("b");
        Car car3 = new Car("c");

        for (int i = 0; i <2; i++) {
            car1.judgeMove(4);
        }
        for (int i = 0; i <3; i++) {
            car3.judgeMove(4);
        }
        winner = new Winner(Arrays.asList(car1, car2, car3));
    }

    @Test
    void getWinners() {
        assertThat(winner.getWinners())
                .isEqualTo(Arrays.asList("c"));
    }
}
