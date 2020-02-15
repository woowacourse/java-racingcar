package racingcargame.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void cars생성_확인() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        assertThat(cars).hasFieldOrPropertyWithValue("cars", carList);
    }

    @Test
    void 현재Cars중_maxPosition에_있는_CarName을_반환() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        assertThat(cars.getWinners()).contains("제이");
        assertThat(cars.getWinners()).contains("라테");
        assertThat(cars.getWinners()).contains("포비");
    }

    @Test
    void 현재Cars를_전진() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("제이"));
        carList.add(new Car("라테"));
        carList.add(new Car("포비"));
        Cars cars = new Cars(carList);
        cars.moveOneRound();
    }
}
