import domain.Car;
import domain.Cars;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    @Test
    @DisplayName("자동차 생성 성공 테스트")
    void createCarsSuccess() {
        // given
        String carNames = "pobi,crong,honux";
        // when
        List<Car> cars = CarRacing.createCars(carNames).getCars();
        // then
        assertThat(cars).hasSize(3);
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("crong"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("honux")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi", "aabbcc,pobi"})
    @DisplayName("자동차 생성 실패 테스트")
    void createCarsFail(String carNames) {
        assertThatThrownBy(() -> {
            CarRacing.createCars(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}