package controller;

import domain.Car;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static controller.PlayRacingController.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-11
 */
class PlayRacingControllerTest {
    private final String carNames = "pobi,crong,hee,iba";
    private String roundCount = "5";
    private List<String> carNameList;
    private List<Car> cars;
    private Race race;

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carNames.split(","));
        cars = new ArrayList<>();
        for (String name : carNameList){
            cars.add(new Car(name));
        }
        race = new Race(cars);
    }


    @Test
    void setCarName_확인() {
        List<Car> carList = setCarName(carNames);
        for (int i = 0; i < Arrays.asList(carNames.split(",")).size(); i++) {
            assertThat(carList.get(i).toString().split(" ")[0]).isEqualTo(carNameList.get(i));
        }
    }

    @Test
    void setRoundCount_확인() {
        assertThat(setRoundCount(Integer.parseInt(roundCount))).isEqualTo(Integer.parseInt(roundCount));
    }

    @Test
    void outputMoveCar_확인() {
        outputMoveCar(race,8);
    }

    @Test
    void outputMoveCar_우승자_결과까지_확인() {
        outputMoveCar(race,8);
        OutputView.outputWinners(race.getRaceWinners());
    }

    @AfterEach
    void tearDown() {
        carNameList = null;
        cars = null;
        race = null;
    }
}