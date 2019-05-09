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
    private String carNames;
    private List<String> carNameList;
    private RacingController racingController;

    @BeforeEach
    void setUp() {
        carNames = "pobi,crong,hee";
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
    void Car_예외처리_확인() {
        String carNamesEx = "heebong";
        assertThrows(IllegalArgumentException.class, () -> {
            List<Car> carList = racingController.makeCarList(Arrays.asList(carNamesEx.split(",")));
        });
    }

    @AfterEach
    void tearDown() {
        racingController = null;
    }
}