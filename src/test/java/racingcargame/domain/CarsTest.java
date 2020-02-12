package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void cars() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
    }

    @Test
    void 현재Cars중_maxPosition_반환() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        assertThat(cars.getMaxPosition()).isEqualTo(0);
    }

    @Test
    void 현재Cars중_넣어준포지션과_같은_위치_자동() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        assertThat(cars.getCarsInSamePositionWith(0)).contains("제이");
        assertThat(cars.getCarsInSamePositionWith(0)).contains("라테");
        assertThat(cars.getCarsInSamePositionWith(0)).contains("포비");
    }

    @Test
    void 현재_cars를_n회전진() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        cars.moveFoward(5);
    }
}
