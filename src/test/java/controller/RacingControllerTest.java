package controller;

import domain.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private final String carNames = "pobi,crong,hee";
    private final int roundCount = 5;
    private List<String> carNameList;
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carNames.split(","));
        racingController = new RacingController();
    }

    @Test
    void Car_리스트_만들기() {
        List<Car> carList = racingController.makeCarList(carNameList);
        for (int i = 0; i < carNameList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(carNameList.get(i));
        }
    }

    @Test
    void Car_이름_길이_예외처리_확인() {
        String carNamesEx = "heebong";
        assertThrows(IllegalArgumentException.class, () -> {
            List<Car> carList = racingController.makeCarList(Arrays.asList(carNamesEx.split(",")));
        });
    }

    @Test
    void Car_이름_중복_예외처리_확인() {
        String carNamesEx = "heebg,crong,hi,pobi,crong";
        assertThrows(IllegalArgumentException.class, () -> {
            List<Car> carList = racingController.makeCarList(Arrays.asList(carNamesEx.split(",")));
        });
    }

    @Test
    void Car_레이스_실행() {
        racingController.moveAllCar(racingController.makeCarList(carNameList), roundCount);
    }

    @AfterEach
    void tearDown() {
        racingController = null;
    }
}