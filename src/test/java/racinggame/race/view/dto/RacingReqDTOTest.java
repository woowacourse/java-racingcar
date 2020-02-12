package racinggame.race.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingReqDTOTest {

    @DisplayName("dto 에서 entity 로 바꾸기")
    @Test
    void toCars() {
        //given
        RacingReqDTO racingReqDTO = new RacingReqDTO("a,b", 1);

        //when
        Cars cars = racingReqDTO.toCars();

        //then
        assertThat(cars).isEqualTo(new Cars(Arrays.asList(new Car("a"), new Car("b"))));
    }
}