package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.RandomNumber;
import racingcar.domain.Winner;

class WinnerTest {
    private static final int MOVE_FORWARD_NUMBER = 8;
    RandomNumber no;
    Winner winners;

    @BeforeEach
    void init() {
        no = new RandomNumber(MOVE_FORWARD_NUMBER);
    }

    @Test
    void getWinners() {
        List<Car> carList = new ArrayList<>();
        Car carPobi = new Car("pobi");
        Car carCrong = new Car("crong");

        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(no);

        winners = new Winner();
        Assertions.assertThat(winners.getWinners(carList)).contains("pobi");
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

        winners = new Winner();
        Assertions.assertThat(winners.getWinners(carList)).contains("crong", "pobi");
    }
}
