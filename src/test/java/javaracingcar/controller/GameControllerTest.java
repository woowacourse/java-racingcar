package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    Game game;
    @BeforeEach
    void setup () {
        List<String> carNames = Arrays.asList("a","b","c","a");
        int trial = 5;
        game = Game.init(carNames, trial);
    }

    @Test
    void generateCars_자동차리스트생성 () {
        List<String> cars = new ArrayList<>();
        cars.add("CarA");
        cars.add("CarB");
        cars.add("CarC");
        List<Car> generatedCars = GameController.generateCars(Arrays.asList("CarA", "CarB", "CarC"));
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(generatedCars.get(i).getName(), cars.get(i));
        }
    }

    @Test
    void name() {
//        playMoveOrStop(3)
    }
}