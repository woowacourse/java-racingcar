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
        testCars = new Cars(carNames, carPositions);
    }

    @Test
    void decideMaxPositionTest() {
        assertThat(testCars.decideMaxPosition()).isEqualTo(107);
    }
    @Test
    void decideWinnersTest() {
        List<String> checkList = Arrays.asList("a","b");
        assertThat(testCars.decideWinners(101)).isEqualTo(checkList);
    }
    @Test
    void carInstantiationTest() {
        List<String> testNames = Arrays.asList("a", "b", "c");
        Cars testCars1 = new Cars(testNames);
        List<String> checkNames = Arrays.asList("a", "b", "c");
        Cars checkCars2 = new Cars(checkNames);
        assertThat(testCars1).isEqualTo(checkCars2);
    }

}
