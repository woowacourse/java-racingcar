package controller;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingControllerTest {
    private final String carNames = "pobi,crong,hee,iba";
    private final int roundCount = 5;
    private List<String> carNameList;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carNames.split(","));
    }

    @Test
    void Car_리스트_만들기() {
        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);

        List<Car> carList = RacingController.setCarsOnRace();
        for (int i = 0; i < carNameList.size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(carNameList.get(i));
        }
    }

    @Test
    void Car_이름_길이_예외처리_반복_확인() {
        String carNamesEx = "heebong";
        InputStream in = new ByteArrayInputStream(carNamesEx.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            RacingController.setCarsOnRace();
        });
    }

    @Test
    void Car_이름_중복_예외처리_반복_확인() {
        String carNamesEx = "heebg,crong,hi,pobi,crong";
        InputStream in = new ByteArrayInputStream(carNamesEx.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            RacingController.setCarsOnRace();
        });
    }

    @Test
    void Car_이름_빈칸_예외처리_반복_확인() {
        String carNamesEx = "1,2,,,,3,";
        InputStream in = new ByteArrayInputStream(carNamesEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void 횟수_1이상_숫자이외_예외처리_확인() {
        String roundCountEx = "0";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void 횟수_숫자_이외_문자_예외처리_확인() {
        String roundCountEx = "asdf";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void 횟수_정수_이외_예외처리_확인() {
        String roundCountEx = "1.2";
        InputStream in = new ByteArrayInputStream(roundCountEx.getBytes());
        System.setIn(in);

        assertThrows(StackOverflowError.class, () -> {
            RacingController.setRoundCount();
        });
    }

    @Test
    void Car_레이스_실행() {
        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);

        RacingController.moveAllCar(RacingController.setCarsOnRace(), roundCount);
    }

    @Test
    void 우승차_출력_프린트문() {
        InputStream in = new ByteArrayInputStream(carNames.getBytes());
        System.setIn(in);

        Race race = RacingController.moveAllCar(RacingController.setCarsOnRace(), roundCount);
        RacingController.printWinners(race);
    }

    @Test
    void 우승차_출력_임의_생성() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car("pobii");
        Car car2 = new Car("crong");
        Car car3 = new Car("hee");
        Car car4 = new Car("hi");

        car1.increasePositionOrNot(3);
        car1.increasePositionOrNot(3);
        car1.increasePositionOrNot(3);
        car1.increasePositionOrNot(3);

        car2.increasePositionOrNot(1);
        car2.increasePositionOrNot(1);
        car2.increasePositionOrNot(1);

        car3.increasePositionOrNot(7);

        car4.increasePositionOrNot(5);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        Race race = new Race(carList);
        RacingController.printWinners(race);
    }

    @AfterEach
    void tearDown() {
        carNameList = null;
    }
}