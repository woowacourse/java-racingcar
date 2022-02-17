package carracing.model;

import static carracing.view.messages.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

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
        //given
        //when
        //then
        assertThatThrownBy(() -> {
            Cars cars = new Cars(Arrays.asList(
                    pobiCar,
                    eastCar,
                    peperCar,
                    new Car("east")
            ));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
    }

    @Test
    @DisplayName("position이 가장 높은 자동차가 우승")
    void 최종우승자_결정_한명() {
        //given
        move(pobiCar, 1);
        move(eastCar, 2);
        move(peperCar, 3);

        Cars cars = new Cars(Arrays.asList(
                pobiCar, eastCar, peperCar
        ));
        //when

        //then
        List<String> winners = cars.getWinners();
        assertThat(winners).contains("peper");
    }

    @Test
    @DisplayName("position이 가장 높은 자동차가 두 대일 때 공동 우승자")
    public void 최종우승자_결정_여러명() throws Exception {
        //given
        move(pobiCar, 1);
        move(eastCar, 3);
        move(peperCar, 3);

        Cars cars = new Cars(Arrays.asList(
                pobiCar, eastCar, peperCar
        ));
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
