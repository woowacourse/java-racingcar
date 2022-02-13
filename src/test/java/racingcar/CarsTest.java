package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private static final String DUPLICATED_NAME_ERROR = "[ERROR] 차 이름은 중복될 수 없습니다.";

    @Test
    public void Car_2개일때_Cars_객체_생성_테스트() {
        List<Car> carList = CarFactory.of("kun,forky");
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(2);
    }

    @Test
    public void Car_3개일때_Cars_객체_생성_테스트() {
        List<Car> carList = CarFactory.of("kun,forky,pobi");
        Cars cars = new Cars(carList);
        assertThat(cars.getNumberOfCar()).isEqualTo(3);
    }

    @Test
    public void 중복된_이름() {
        assertThatThrownBy(() -> new Cars(CarFactory.of("kun,kun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NAME_ERROR);
    }
}
