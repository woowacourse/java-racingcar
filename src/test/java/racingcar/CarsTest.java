package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    List<String> carNames;
    List<Integer> carPositions;
    Cars testCars;

    @BeforeEach
    void setUp(){
        carNames = Arrays.asList("a", "b", "c");
        carPositions = Arrays.asList(101, 101, 99);
        testCars = new Cars(carNames);
        testCars.setPosition(carPositions);
    }
    @Test
    void decideMaxPositionTest() {
        assertThat(testCars.decideMaxPosition()).isEqualTo(101);
    }
    @Test
    void decideWinnersTest() {
        List<String> checkList = Arrays.asList("a","b");
        assertThat(testCars.decideWinners(101)).isEqualTo(checkList);
    }
}
