package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RandomNo;

class WinnerTest {
    private static final int MOVE_FORWARD_NUMBER = 8;
    RandomNo no;

    @BeforeEach
    void init() {
        no = new RandomNo(MOVE_FORWARD_NUMBER);
    }

    @Test
    void getWinners() {
        List<Car> carList = new ArrayList<>();
        Car carPobi = new Car("pobi");
        Car carCrong = new Car("crong");

        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(no);

        Assertions.assertThat(Winner.getWinners(carList)).contains("pobi");
    }

    @Test
    void getWinners_When_MoreThan_2() {
        List<Car> carList = new ArrayList<>();
        Car carPobi = new Car("pobi");
        Car carCrong = new Car("crong");

        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(no);
		carCrong.move(no);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong", "pobi");
    }
}
