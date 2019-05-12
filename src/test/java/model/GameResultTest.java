/*
 * @(#)GameResultTest.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
class GameResultTest {
    /*게임결과(우승자) 추출을 테스팅하는 클래스*/
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