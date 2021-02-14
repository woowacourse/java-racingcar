package racingcar.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("특정 자동차가 우승을 하는 상황을 만들어놓고 그 우승자가 정상적으로 나오는지 확인")
    @Test
    void checkWinner() {
        Cars cars = winnerSetUp();
        assertThat(cars.getWinners()).containsExactly("cogi", "pobi");
    }

    public Cars winnerSetUp() {
        Car car1 = new Car("jino", 2);
        Car car2 = new Car("cogi", 3);
        Car car3 = new Car("pobi", 3);

        return new Cars(asList(car1, car2, car3));
    }
}
