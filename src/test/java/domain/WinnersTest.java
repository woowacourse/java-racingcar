package domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnersTest {
    private static final int EXPECTED_MAX_POSITION = 7;
    private static final int EXPECTED_SIZE = 2;

    private static Car winnerCar1;
    private static Car winnerCar2;
    private static Winners winners;

    @BeforeAll
    static void setup() {
        winnerCar1 = new Car("타미", EXPECTED_MAX_POSITION);
        winnerCar2 = new Car("유안", EXPECTED_MAX_POSITION);
        winners = new Winners(Arrays.asList(winnerCar1, winnerCar2));
    }

    @Test
    void getTest() {
        assertThat(winners.getWinner(0)).isEqualTo(winnerCar1);
    }

    @Test
    void getSizeTest() {
        assertThat(winners.getSize()).isEqualTo(EXPECTED_SIZE);
    }
}
