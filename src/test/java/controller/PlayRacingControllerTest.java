package controller;

import domain.Car;
import domain.Const;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static controller.PlayRacingController.setCarName;
import static controller.PlayRacingController.setRoundCount;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Heebg
 * User: heebg
 * Date: 2019-05-11
 */
class PlayRacingControllerTest {
    private final String carNames = "pobi,crong,hee,iba";
    private String roundCount = "5";
    private List<String> carNameList;
    private final String excep = "Excep";
    private Car exCar;
    private String exRoundCount = "100";

    @BeforeEach
    void setUp() {
        carNameList = Arrays.asList(carNames.split(","));
        exCar = new Car(excep);
    }


    @Test
    void setCarName_확인() {
        List<Car> carList = setCarName(carNames);
        for (int i = 0; i < Arrays.asList(carNames.split(",")).size(); i++) {
            assertThat(carList.get(i).toString().split(" ")[0]).isEqualTo(carNameList.get(i));
        }
    }

    @Test
    void setCarName_이름_6글자_이상_예외() {
        String carNamesEx = "heebong";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setCarName_이름_중복_예외() {
        String carNamesEx = "heebg,crong,hi,pobi,crong";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setCarName_이름_빈칸_예외() {
        String carNamesEx = "";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setCarName_이름_빈칸_여러개_예외() {
        String carNamesEx = ",";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setCarName_이름_빈칸_앞에_예외() {
        String carNamesEx = ",,,,3";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setCarName_이름_빈칸_가운데_예외() {
        String carNamesEx = "1,2,,,,3";
        System.setIn(new ByteArrayInputStream(excep.getBytes()));
        assertThat(setCarName(carNamesEx).get(0)).isEqualTo(exCar);
    }

    @Test
    void setRoundCount_확인() {
        assertThat(setRoundCount(Integer.parseInt(roundCount))).isEqualTo(Integer.parseInt(roundCount));
    }

    @Test
    void setRoundCount_0_미만_예외() {
        String input = "0";
        System.setIn(new ByteArrayInputStream(exRoundCount.getBytes()));
        assertThat(setRoundCount(Integer.parseInt(input))).isEqualTo(Integer.parseInt(exRoundCount));
    }

    @Test
    void setRoundCount_문자_예외() {
        String input = "asdf";
        assertThrows(NumberFormatException.class, () -> {
            setRoundCount(Integer.parseInt(input));
        });
    }

    @Test
    void setRoundCount_정수_이외_예외() {
        String input = "1.2";
        assertThrows(NumberFormatException.class, () -> {
            setRoundCount(Integer.parseInt(input));
        });
    }

    @AfterEach
    void tearDown() {
        carNameList = null;
        exCar = null;
    }
}