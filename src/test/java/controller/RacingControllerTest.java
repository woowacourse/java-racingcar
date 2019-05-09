package controller;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    void 우승차_출력_프린트문() {
        Race race = racingController.moveAllCar(racingController.makeCarList(carNameList), roundCount);
        racingController.printWinners(race);
    }

    @Test
    void 우승차_출력_임의_생성() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("hee");
        Car car4 = new Car("hi");

        car1.increasePositionOrNot(2);
        car1.increasePositionOrNot(2);
        car1.increasePositionOrNot(2);

        car2.increasePositionOrNot(9);
        car2.increasePositionOrNot(8);
        car2.increasePositionOrNot(8);

        car3.increasePositionOrNot(7);

        car4.increasePositionOrNot(2);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        Race race = new Race(carList);
        racingController.printWinners(race);
    }

    @AfterEach
    void tearDown() {
        racingController = null;
    }
}