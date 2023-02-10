package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @ParameterizedTest(name = "Car 객체 생성 테스트 name = {0}")
    @ValueSource(strings = {"pobi", "crong", "honux", "hi hi", "jj503"})
    void createCarTest(String name) {
        Car car = new Car(name);
        assertThat(car.getCarName()).isEqualTo(name);
    }

    @ParameterizedTest(name = "Car 객체 생성 5자 초과 및 공백 예외 테스트 name = {0}")
    @ValueSource(strings = {"pobiiii","abcdef", "", "  "})
    void createExceptionCarTest(String name) {
        assertThatThrownBy(() -> {
            new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("랜덤 값이 4미만일 경우 테스트")
    void stopByRandom() {
        Car car = new Car("test");
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(0,1,2,3));

        CarsTest.TestNumberGenerator testNumberGenerator =
                new CarsTest.TestNumberGenerator(randomNumbers);

        car.moveByRandom(testNumberGenerator.generateNumber());

        assertThat(car.getCarLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4이상일 경우 테스트")
    void moveByRandom() {
        Car car = new Car("test");
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(9,8,7,6));

        CarsTest.TestNumberGenerator testNumberGenerator =
                new CarsTest.TestNumberGenerator(randomNumbers);

        car.moveByRandom(testNumberGenerator.generateNumber());

        assertThat(car.getCarLocation()).isEqualTo(1);
    }
}