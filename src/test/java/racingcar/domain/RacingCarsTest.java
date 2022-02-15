package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    private static final int CAR_SIZE = 3;

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
    @DisplayName("최대 거리 이동한 자동차를 뽑는 테스트")
    void getRacingCarWithMaxPositionTest() {

        RacingCar racingCar1 = RacingCar.generateRacingCar("pobi");
        RacingCar racingCar2 = RacingCar.generateRacingCar("crong");
        RacingCar maxPositionCar = RacingCar.generateRacingCar("honux");
        maxPositionCar.goOrStay(9);
        maxPositionCar.goOrStay(9);

        RacingCars racingCars = new RacingCars(List.of(racingCar1, racingCar2, maxPositionCar));

        RacingCar actual = racingCars.getRacingCarWithMaxPosition();
        assertThat(actual).isEqualTo(maxPositionCar);
    }

}