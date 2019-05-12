package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    List<Car> carList;
    Winners winners;
    GameResult gameResult;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        winners = new Winners();
        gameResult = new GameResult();
    }

    @Test
    void 우승자추출_검사() {
        carList.add(new Car(new CarName("coozy"), 5));
        carList.add(new Car(new CarName("pobi"), 4));
        carList.add(new Car(new CarName("jason"), 3));
        carList.add(new Car(new CarName("nick"), 5));

        winners.addWinners("coozy");
        winners.addWinners("nick");

        Cars cars = new Cars(carList);

        assertThat(gameResult.findWinner(cars).toString()).isEqualTo(winners.toString());
    }
}