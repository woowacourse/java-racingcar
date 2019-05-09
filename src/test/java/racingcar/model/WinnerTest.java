package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    private Car firstCar;
    private Car secondCar;
    private Car thirdCar;
    private List<Car> carList;
    private List<Car> winnerCarList;
    private Winner winner;

    @BeforeEach
    void setUp() {
        firstCar = new Car("firstCar");
        secondCar = new Car("secondCar");
        thirdCar = new Car("thirdCar");
        carList = Arrays.asList(firstCar, secondCar, thirdCar);
        winner = new Winner(carList);
        winnerCarList = new ArrayList<>();
    }

    @Test
    void 움직이지않은경우_우승자확인() {
        winnerCarList.add(firstCar);
        winnerCarList.add(secondCar);
        winnerCarList.add(thirdCar);

        assertThat(winner.getWinners()).isEqualTo(winnerCarList);
    }

    @Test
    void 한개의_자동차만우승인경우_우승자확인() {
        firstCar.move(4);
        secondCar.move(0);
        thirdCar.move(0);
        winnerCarList.add(firstCar);

        assertThat(winner.getWinners()).isEqualTo(winnerCarList);
    }

    @Test
    void 한개이상의_자동차가우승인경우_우승확인() {
        firstCar.move(4);
        secondCar.move(4);
        thirdCar.move(0);
        winnerCarList.add(firstCar);
        winnerCarList.add(secondCar);

        assertThat(winner.getWinners()).isEqualTo(winnerCarList);
    }
}