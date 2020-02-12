package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름_부여() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 전진하기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(4)).isEqualTo(1);
    }

    @Test
    void 멈추기() {
        Car car = new Car("pobi");
        assertThat(car.movePosition(3)).isEqualTo(0);
    }

    @Test
    void 여러대의_차_진행상황_출력() {
        List<Car> carList = new ArrayList<Car>();
        carList.add(new Car("pobi"));
        carList.add(new Car("elly"));
        carList.add(new Car("rutgo"));
        Cars cars = new Cars(carList);
        cars.getCar(0).movePosition(5);
        cars.getCar(0).movePosition(5);
        cars.getCar(0).movePosition(5);
        cars.getCar(1).movePosition(5);
        cars.getCar(2).movePosition(5);
        assertThat(cars.printCurrentResult()).isEqualTo("pobi : ---\nelly : -\nrutgo : -\n");
    }
}
