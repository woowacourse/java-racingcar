package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("우승자 선정이 잘 되는지 테스트")
    public void check_get_winners() {
        String carNames[] = {"test1", "test2", "test3"};
        int distance[] = {8, 1, 3};
        Cars cars = new Cars(carNames, distance);

        assertThat(cars.getWinners(8)).isEqualTo("test1");
    }

}