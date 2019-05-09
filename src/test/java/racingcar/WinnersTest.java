package racingcar;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    @Test
    void decideMaxPositionTest() {
        Car testCar1 = new Car("aaa");
        testCar1.setPosition(5);
        Car testCar2 = new Car("bbb");
        testCar2.setPosition(2);
        Car testCar3 = new Car("ccc");
        testCar3.setPosition(100);

        List<Car> carList = Arrays.asList(testCar1, testCar2, testCar3);
        assertThat(Winners.decideMaxPosition(carList)).isEqualTo(100);
    }

}