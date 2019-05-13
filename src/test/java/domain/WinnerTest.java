package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {
    Winner winner;

    @BeforeEach
    void setUp() {
        Car car1 = new Car("a", 2);
        Car car2 = new Car("b", 1);
        Car car3 = new Car("c", 3);

        winner = new Winner(Arrays.asList(car1, car2, car3));
    }

    @Test
    void getWinnerNames() {
        assertThat(winner.getWinnerNames())
                .isEqualTo(Arrays.asList("c"));
    }
}
