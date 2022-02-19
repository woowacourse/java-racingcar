package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinnerCarsTest {

    @Test
    @DisplayName("잘못된 우승자 판별 예외처리")
    void wrongWinnerException() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new Name("sun"), 4));
        cars.add(new Car(new Name("ron"), 2));

        assertThatThrownBy(() -> new WinnerCars(cars, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("우승자 판별");
    }
}
