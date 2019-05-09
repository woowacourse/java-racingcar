package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    void 자동차_객체_테스트() {
        String[] name = {"pobi","crong","honux"};
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("pobi"));
        carList.add(new Car("crong"));
        carList.add(new Car("honux"));

        for(int i = 0 ; i < carList.size() ; i++){
            assertThat(racingGame.setCarName(name).get(i).getName()).isEqualTo(carList.get(i).getName());
            assertThat(racingGame.setCarName(name).get(i).getPosition()).isEqualTo(carList.get(i).getPosition());
        }
    }

    @AfterEach
    void tearDown() {
        racingGame = null;
    }
}
