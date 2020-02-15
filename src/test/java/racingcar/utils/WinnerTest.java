package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.RandomNo;
import racingcar.domain.Winner;

class WinnerTest {

    private List<Car> carList;
    private Car carPobi;
    private Car carCrong;
    private RandomNo randomNo;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carPobi = new Car(new CarName("pobi"));
        carCrong = new Car(new CarName("crong"));
        randomNo = new RandomNo(4);
    }

    @Test
    void getWinners() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(randomNo);
        carCrong.move(randomNo);
        carCrong.move(randomNo);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong");
    }

    @Test
    void getWinners_When_MoreThan_2() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(randomNo);
        carCrong.move(randomNo);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong", "pobi");
    }
}
