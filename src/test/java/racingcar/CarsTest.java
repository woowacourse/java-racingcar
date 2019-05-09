package racingcar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void decideMaxPositionTest() {
        List<String> carNames = Arrays.asList("a", "b", "c");
        List<Integer> carPositions = Arrays.asList(5, 100, 1000);
        Cars testCars = new Cars(carNames);
        testCars.setPosition(carPositions);

        assertThat(testCars.decideMaxPosition()).isEqualTo(1000);
    }
    @Test
    void decideWinnersTest() {
        List<String> carNames = Arrays.asList("a", "b", "c");
        List<Integer> carPositions = Arrays.asList(101, 101, 99);
        Cars testCars = new Cars(carNames);
        testCars.setPosition(carPositions);

        List<String> checkList = Arrays.asList("a","b");
        assertThat(testCars.decideWinners(101)).isEqualTo(checkList);
    }
}
