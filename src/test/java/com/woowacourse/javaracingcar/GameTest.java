package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class GameTest {
    NumberGenerator numberGenerator;
    Game game;

    @BeforeEach
    void setUp() {


    }

    @Test
    public void 자동차_전진() {
        int[] expected = {1,2,5};
        numberGenerator = new TestNumberGenerator(expected);

        Car car = new Car("pobi");
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        game = new Game(numberGenerator, cars);

        loopGame(game, expected.length);
        assertThat(game.getWinners().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    public void 정상_게임_종료_우승자반환() {
       List<Car> cars = new ArrayList<>();
       cars.add(new Car("pobi"));
       cars.add(new Car("crong"));
       cars.add(new Car("honux"));

       int[] expected = {1,2,3,1,2,4,4,5,6};
       numberGenerator = new TestNumberGenerator(expected);

       game = new Game(numberGenerator, cars);

       loopGame(game, 3);
       assertThat(game.getWinners().get(0).getName()).isEqualTo("honux");
    }

    @Test
    public void 정상_게임_종료_공동_우승자반환() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        int[] expected ={4,1,4,5,2,5,6,4,6};
        numberGenerator = new TestNumberGenerator(expected);
        List<Car> expectedWinnerList = new ArrayList<>();
        expectedWinnerList.add(cars.get(0));
        expectedWinnerList.add(cars.get(2));

        game = new Game(numberGenerator, cars);
        loopGame(game, 3);
        List<Car> actualWinnerList = game.getWinners();

        assertThat(actualWinnerList).isEqualTo(expectedWinnerList);
    }

    void loopGame(Game g, int loops) {
        for (int i = 0; i < loops; i++) {
            g.loop();
        }
    }
}