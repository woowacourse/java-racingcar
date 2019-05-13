package controller;

import domain.Car;
import domain.Const;
import domain.Race;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static controller.RacingController.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void setCars_이름_6글자_이상_예외() {
        String carNameEx = "heebon";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setCars_이름_중복_예외() {
        String carNameEx = "heebg,crong,hi,pobi,crong";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setCars_이름_빈칸_예외() {
        String carNameEx = "";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setCars_이름_빈칸_여러개_예외() {
        String carNameEx = ",";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setCars_이름_앞에_빈칸_예외() {
        String carNameEx = ",,1";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setCars_이름_가운데_빈칸_예외() {
        String carNameEx = "hee,,bong";
        assertThrows(IllegalArgumentException.class, () -> {
            setCars(Arrays.asList(carNameEx.split(",")));
        });
    }

    @Test
    void setRoundCount_확인() {
        assertThat(setRoundCount(roundCount)).isEqualTo(roundCount);
    }

    @Test
    void setRoundCount_0_이하_예외() {
        String roundCountEx = String.valueOf(Const.ZERO);
        assertThrows(IllegalArgumentException.class, () -> {
            setRoundCount(Integer.parseInt(roundCountEx));
        });
    }

    @Test
    void setRoundCount_정수_이외_예외() {
        String roundCountEx = "1.2";
        assertThrows(IllegalArgumentException.class, () -> {
            setRoundCount(Integer.parseInt(roundCountEx));
        });
    }

    @Test
    void setRoundCount_정수_이외_문자_예외() {
        String roundCountEx = "heeboing";
        assertThrows(IllegalArgumentException.class, () -> {
            setRoundCount(Integer.parseInt(roundCountEx));
        });
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