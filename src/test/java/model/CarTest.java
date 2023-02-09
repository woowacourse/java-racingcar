package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux", "hi hi", "jj503"})
    @DisplayName("Car 객체 생성 테스트")
    void createCarTest(String name) {
        Car car = new Car(name);
        assertThat(car.getCarName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiiii", "", "  "})
    @DisplayName("Car 객체 생성 예외 테스트")
    void createExceptionCarTest(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 값이 4미만일 경우 테스트")
    void stopByRandom(int randNum) {
        Car car = new Car("test");
        car.moveByRandom(randNum);

        assertThat(car.getCarLocation()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    @DisplayName("랜덤 값이 4이상일 경우 테스트")
    void moveByRandom(int randNum) {
        Car car = new Car("test");
        car.moveByRandom(randNum);

        assertThat(car.getCarLocation()).isEqualTo(1);
    }
}