package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingWinnersTest {
    private String[] carNames = {"pobi", "cony", "whale"};
    ArrayList<Integer>[] carPositionHistory;

    @BeforeEach
    public void setUp() {
        final int numOfCar = 3;

        carPositionHistory = new ArrayList[numOfCar];
        for (int i = 0; i < numOfCar; i++) {
            carPositionHistory[i] = new ArrayList<>();
        }

        carPositionHistory[0].add(0);
        carPositionHistory[0].add(0);
        carPositionHistory[0].add(1);

        carPositionHistory[1].add(1);
        carPositionHistory[1].add(2);
        carPositionHistory[1].add(3);

        carPositionHistory[2].add(1);
        carPositionHistory[2].add(2);
        carPositionHistory[2].add(3);
    }

    @Test
    public void getMaxPositionTest() {
        assertThat(RacingWinners.getMaxPosition(carNames, carPositionHistory)).isEqualTo(3);
    }

    @Test
    public void getWinnersTest() {
        int maxPosition = 3;
        List<String> winners = new ArrayList<>();
        winners.add("cony");
        winners.add("whale");

        assertThat(RacingWinners.getWinners(carNames, carPositionHistory, maxPosition)).isEqualTo(winners);
    }
}
