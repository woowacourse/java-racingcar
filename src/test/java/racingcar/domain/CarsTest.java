package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {

    @Test
    void maxPositionCar() {
        String carsName = "pobi, jun, aaa";
        Cars cars = new Cars(new Names(carsName));
        List<Car> carList = cars.getCars();

        carList.get(0).movePosition(5);
        carList.get(1).movePosition(3);
        carList.get(2).movePosition(3);

        assertEquals(carList.get(0), cars.getMaxPositionCar());
    }
}
