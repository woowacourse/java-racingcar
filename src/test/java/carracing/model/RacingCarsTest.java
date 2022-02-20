package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    Car eastCar;
    Car pobiCar;
    Car peperCar;

    @BeforeEach
    void car_init() {
        eastCar = new Car("east");
        pobiCar = new Car("pobi");
        peperCar = new Car("peper");
    }

    @Test
    @DisplayName("자동차의 이름이 중복될 경우 에러 발생")
    void validate_자동차이름_중복() {
        assertThatThrownBy(() -> {
            RacingCars racingCars = new RacingCars(Arrays.asList("pobi", "east", "east", "peper"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("우승자는 최소 한 대 이상")
    void 최종우승자_결정() {
        //given
        RacingCars racingCars = new RacingCars(Arrays.asList("pobi", "east", "peper"));
        racingCars.moveCars();
        //when
        int minimumWinnersCount = 1;
        //then
        List<String> winners = racingCars.getWinners();
        assertThat(winners.size()).isGreaterThanOrEqualTo(minimumWinnersCount);
    }
}
