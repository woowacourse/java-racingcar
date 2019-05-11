package controller;

import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static controller.RacingController.setCars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

/*    @Test
    void Car_레이스_실행() {
        RacingController.moveAllCar(RacingController.setCarName(carNames), roundCount);
    }

    @Test
    void 우승차_출력_프린트문() {
        Race race = RacingController.moveAllCar(RacingController.setCarName(carNames), roundCount);
        RacingController.printWinners(race);
    }*/

    @AfterEach
    void tearDown() {
        carNameList = null;
    }
}