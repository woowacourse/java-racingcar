package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void movingCarsTest() {
        // given
        MovingStrategy movingStrategy = new ForwardMovingStrategy();
        Car pobi = new Car("pobi", movingStrategy);
        Car crong = new Car("crong", movingStrategy);
        Cars cars = new Cars(List.of(
                pobi,
                crong
        ));

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }

        // then
        assertThat(pobi.getPosition()).isEqualTo(3);
        assertThat(crong.getPosition()).isEqualTo(3);
    }


    @DisplayName("우승한 자동차 선별 테스트")
    @Test
    void winnerCarTest() {
        // given
        MovingStrategy forwardStrategy = new ForwardMovingStrategy();
        MovingStrategy notMovingStrategy = new NotMovingStrategy();
        Car pobi = new Car("pobi", forwardStrategy);
        Car crong = new Car("crong", notMovingStrategy);
        Cars cars = new Cars(List.of(
                pobi,
                crong
        ));

        // when
        for (int i = 0; i < 2; i++) {
            cars.moveCars();
        }
        Cars winnerCars = cars.getWinnerCars();

        // then
        assertThat(pobi.getPosition()).isEqualTo(3);
        assertThat(crong.getPosition()).isEqualTo(1);

        assertThat(winnerCars.getCarsWinnerFormat())
                .contains("pobi")
                .doesNotContain("crong");

    }


}