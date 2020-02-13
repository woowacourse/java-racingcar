package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void 여러대의_차_진행상황_출력() {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("pobi"));
        carList.add(new Car("elly"));
        carList.add(new Car("rutgo"));
        Cars cars = new Cars();
        for (Car car : carList){
            cars.addCar(car);
        }
        cars.getCar(0).movePosition(5);
        cars.getCar(0).movePosition(5);
        cars.getCar(0).movePosition(5);
        cars.getCar(1).movePosition(5);
        cars.getCar(2).movePosition(5);
        assertThat(cars.getCurrentResult()).isEqualTo("pobi : ---\nelly : -\nrutgo : -\n");
    }
}
