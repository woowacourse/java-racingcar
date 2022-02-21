package carracing.model;

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
    @DisplayName("position이 가장 높은 자동차가 우승")
    void 최종우승자_결정_한명() {
        //given
        move(pobiCar, 1);
        move(eastCar, 2);
        move(peperCar, 3);
        RacingCars cars = new RacingCars(Arrays.asList(pobiCar, eastCar, peperCar));
        //when
        //then
        List<String> winners = cars.getWinners();
        assertThat(winners).contains("peper");
    }

    @Test
    @DisplayName("position이 가장 높은 자동차가 두 대일 때 공동 우승자")
    void 최종우승자_결정_여러명() throws Exception {
        //given
        move(pobiCar, 1);
        move(eastCar, 3);
        move(peperCar, 3);
        RacingCars cars = new RacingCars(Arrays.asList(pobiCar, eastCar, peperCar));
        // when
        // then
        List<String> winners = cars.getWinners();
        assertThat(winners).contains("peper", "east");
    }

    void move(Car car, int cnt) {
        while ((cnt--) > 0) {
            car.move(() -> true);
        }
    }
}
