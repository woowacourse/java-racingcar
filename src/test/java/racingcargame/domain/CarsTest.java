package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CarsTest {

    @Test
    void cars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
    }

}
