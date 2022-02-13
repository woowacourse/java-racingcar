package racingcar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    public void Car_2개일때_Cars_객체_생성_테스트() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("kun"));
        carList.add(new Car("forky"));
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(2);
    }

    @Test
    public void Car_3개일때_Cars_객체_생성_테스트() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carList.add(new Car(String.valueOf(i)));
        }
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(3);
    }
}
