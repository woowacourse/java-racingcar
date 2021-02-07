package javaracingcar.controller;

import javaracingcar.domain.Car;
import javaracingcar.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    @Test
    @DisplayName("GameController의 자동차 생성 메서드 테스트")
    void generateCars_NonDuplicatedCarNames_Success() {
        List<String> cars = new ArrayList<>();
        cars.add("CarA");
        cars.add("CarB");
        cars.add("CarC");
        List<Car> generatedCars = GameController.generateCars(Arrays.asList("CarA", "CarB", "CarC"));
        for (int i = 0; i < cars.size(); i++) {
            assertEquals(generatedCars.get(i)
                                      .getName(), cars.get(i));
        }
    }
}