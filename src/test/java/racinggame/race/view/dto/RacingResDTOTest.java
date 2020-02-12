package racinggame.race.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.Car;
import racinggame.race.car.engine.FixedEngine;

import static org.assertj.core.api.Assertions.assertThat;

class RacingResDTOTest {

    @DisplayName("반환용 객체에서 거리에 따른 진행정도(bar)값 반환하기")
    @Test
    void getDistanceBar() {
        //given
        Car car = new Car("bebop");
        car.moveWith(new FixedEngine());

        //when
        RacingResDTO racingResDTO = RacingResDTO.from(car);

        //then
        assertThat(racingResDTO.getDistance()).isEqualTo("--");
    }
}