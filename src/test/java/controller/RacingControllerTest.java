package controller;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<Car> carList = RacingController.setCarName(carNames);
        for (int i = 0; i < Arrays.asList(carNames.split(",")).size(); i++) {
            assertThat(carList.get(i).getName()).isEqualTo(carNameList.get(i));
        }
    }

    @Test
    void Car_이름_길이_예외처리_반복_확인() {
        String carNamesEx = "heebong";

        assertThrows(IllegalArgumentException.class, () -> {
            RacingController.inputCarNames(Arrays.asList(carNamesEx.split(".")));
        });
    }

    @Test
    void Car_이름_중복_예외처리_반복_확인() {
        String carNamesEx = "heebg,crong,hi,pobi,crong";
        assertThrows(IllegalArgumentException.class, () -> {
            RacingController.inputCarNames(Arrays.asList(carNamesEx.split(".")));
        });
    }

    @Test
    void Car_이름_빈칸_예외처리_반복_확인() {
        String carNamesEx = "1,2,,,,3,";
        assertThrows(IllegalArgumentException.class, () -> {
            RacingController.inputCarNames(Arrays.asList(carNamesEx.split(".")));
        });
    }

    @Test
    void 횟수_1이상_숫자이외_예외처리_확인() {
        String input = "0";

        assertThrows(IllegalArgumentException.class, () -> {
            RacingController.inputRoundCount(Integer.parseInt(input));
        });
    }

    @Test
    void 횟수_숫자_이외_문자_예외처리_확인() {
        String input = "asdf";

        assertThrows(NumberFormatException.class, () -> {
            RacingController.setRoundCount(Integer.parseInt(input));
        });
    }

    @Test
    void 횟수_정수_이외_예외처리_확인() {
        String input = "1.2";

        assertThrows(NumberFormatException.class, () -> {
            RacingController.setRoundCount(Integer.parseInt(input));
        });
    }

    @Test
    void Car_레이스_실행() {
        RacingController.moveAllCar(RacingController.setCarName(carNames), roundCount);
    }

    @Test
    void 우승차_출력_프린트문() {
        Race race = RacingController.moveAllCar(RacingController.setCarName(carNames), roundCount);
        RacingController.printWinners(race);
    }

    @AfterEach
    void tearDown() {
        carNameList = null;
    }
}