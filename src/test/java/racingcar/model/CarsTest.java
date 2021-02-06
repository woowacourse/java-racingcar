package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    public void Cars_getWinner_동작_테스트() {
        String carNames[] = {"test1", "test2", "test3"};
        int distance[] = {8, 1, 3};
        Cars cars = new Cars(carNames, distance);
        assertThat(cars.getWinner(8)).isEqualTo("test1");
    }


}