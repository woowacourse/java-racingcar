package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.domain.Car.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private List<Car> carList = new ArrayList<>();
    private Car pobi = new Car("pobi");
    private Car kyle = new Car("kyle");
    private Car hodol = new Car("hodol");
    private Car rutgo = new Car("rutgo");

    @BeforeEach
    void generateCarList() {
        pobi.move(CRITERIA);
        pobi.move(CRITERIA);
        kyle.move(CRITERIA);
        rutgo.move(CRITERIA);
        carList.add(hodol);
        carList.add(pobi);
        carList.add(kyle);
        carList.add(rutgo);
    }

    @Test
    @DisplayName("최대 포지션의 반환되는지")
    void getMaxCar() {
        Cars cars = new Cars(carList);
        int maxPosition = cars.maxPosition();
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 명단이 반환되는지")
    void getWinners() {
        Cars cars = new Cars(carList);
        assertThat(cars.getWinners()).containsExactly("pobi", "", "", "");
    }
}
