package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;

class WinnerTest {

    private List<Car> carList;
    private Car carPobi;
    private Car carCrong;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carPobi = new Car("pobi");
        carCrong = new Car("crong");
    }

    @Test
    void getWinners() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(4);
        carCrong.move(4);
        carCrong.move(4);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong");
    }

    @Test
    void getWinners_When_MoreThan_2() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(4);
        carCrong.move(4);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong", "pobi");
    }
}
