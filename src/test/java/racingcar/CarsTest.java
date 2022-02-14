package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void 최종_우승자_출력() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("bom", 3));
        carList.add(new Car("sun", 4));
        Cars cars = new Cars(carList);

        String winnerName = cars.findWinner();
        assertThat(winnerName).contains("sun").doesNotContain("bom");
    }
}
