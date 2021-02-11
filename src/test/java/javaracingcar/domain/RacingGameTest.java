package javaracingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {
    Car carA, carB, carC;
    Cars cars;
    int trial;
    RacingGame racingGame;

    @BeforeEach
    void setup() {
        carA = new Car("CarA", 3);
        carB = new Car("CarB", 3);
        carC = new Car("CarC", 2);
        cars = new Cars(Arrays.asList(carA, carB, carC));
        trial = 3;
        racingGame = new RacingGame(cars, trial);
    }

    @Test
    @DisplayName("실행 횟수 검증")
    void trialCountTest() {
        int cnt = 0;
        while (!racingGame.isEnd()) {
            racingGame.playOneRound();
            cnt++;
        }
        assertEquals(trial, cnt);
    }

    @Test
    @DisplayName("우승자 찾기")
    void getWinnersTest() {
        assertTrue(racingGame.getWinners().contains(carA));
        assertTrue(racingGame.getWinners().contains(carB));
        assertFalse(racingGame.getWinners().contains(carC));
    }

}