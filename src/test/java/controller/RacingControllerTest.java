package controller;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static controller.RacingController.setCars;
import static controller.RacingController.setRacingCars;
import static org.assertj.core.api.Assertions.assertThat;

class RacingControllerTest {
    private final String carNames = "pobi,crong,hee,iba";
    private final int roundCount = 5;
    private List<String> carNameList;
    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carNames.split(","));
        carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(new Car(name));
        }
    }

    @Test
    void setCars_확인() {
        assertThat(setCars(carNameList)).isEqualTo(carList);
    }

    @Test
    void setRacingCars_확인() {
        assertThat(setRacingCars(carList)).isEqualTo(new Race(carList));
    }

    @AfterEach
    void tearDown() {
        carNameList = null;
        carList = null;
    }
}