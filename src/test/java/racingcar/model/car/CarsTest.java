package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        Cars cars = getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        String carsPositionFormat = cars.getCarsPositionFormat();
        // then
        assertThat(carsPositionFormat)
                .contains("pobi : ---")
                .contains("crong : -");
    }


    @DisplayName("우승한 자동차 선별 테스트")
    @Test
    void winnerCarTest() {
        // given
        Cars cars = getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .doesNotContain("crong");

    }

    @DisplayName("우승한 자동차 출력 형식 테스트")
    @Test
    void winnerCarFormatTest() {
        // given
        Cars cars = getCarsByStrategies();

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .doesNotContain("crong");

    }


    /*
        position = 3 인 pobi,
        position = 1 인 crong 을 포함한 Cars를 반환
     */
    private Cars getCarsByStrategies() {
        MovingStrategy movingStrategy = new ForwardMovingStrategy();
        MovingStrategy notMovingStrategy = new NotMovingStrategy();

        Car pobi = new Car("pobi", movingStrategy);
        Car crong = new Car("crong", notMovingStrategy);
        return new Cars(List.of(
                pobi,
                crong
        ));
    }


}