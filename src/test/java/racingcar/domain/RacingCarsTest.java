package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    private static final int CAR_SIZE = 3;
    private static final String WINNER_NAME_DELIMITER = ", ";
    private RacingCar racingCar1;
    private RacingCar racingCar2;
    private RacingCar racingCar3;
    private List<RacingCar> racingCarList;

    @BeforeEach
    public void setUp() {
        racingCar1 = RacingCar.generateRacingCar("pobi");
        racingCar2 = RacingCar.generateRacingCar("crong");
        racingCar3 = RacingCar.generateRacingCar("honux");
        racingCarList = new ArrayList<>(Arrays.asList(racingCar1, racingCar2, racingCar3));
    }

    @Test
    @DisplayName("입력한 이름이 객체로 생성되었는지 확인하는 테스트")
    void joinTest() {

        String[] racingCarNames = new String[]{"pobi", "crong", "honux"};
        RacingCars racingCars = new RacingCars();
        racingCars.join(racingCarNames);
        List<RacingCar> racingCarList = racingCars.getRacingCars();
        assertAll(
                () -> assertThat(racingCarList.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(racingCarList.get(1).getName()).isEqualTo("crong"),
                () -> assertThat(racingCarList.get(2).getName()).isEqualTo("honux"),
                () -> assertThat(racingCarList.size()).isEqualTo(CAR_SIZE)
        );

    }

    @Test
    @DisplayName("위치가 제일 먼 자동차가 우승자인지 테스트")
    public void getWinnersTest() {

        racingCar2.goOrStay(5);
        racingCar3.goOrStay(5);
        racingCar3.goOrStay(7);

        RacingCars racingCars = new RacingCars(racingCarList);
        String winnersName = racingCars.getWinnersName();

        assertThat(winnersName).isEqualTo(racingCar3.getName());
    }

    @Test
    @DisplayName("우승자가 여러명일때 쉼표를 이용해 구분하는 기능")
    public void getWinnersNameTest() {

        racingCar2.goOrStay(5);
        racingCar3.goOrStay(7);
        RacingCars racingCars = new RacingCars(racingCarList);
        String actual = racingCars.getWinnersName();
        String winnersName = racingCar2.getName() + WINNER_NAME_DELIMITER + racingCar3.getName();

        assertThat(actual).isEqualTo(winnersName);
    }

}