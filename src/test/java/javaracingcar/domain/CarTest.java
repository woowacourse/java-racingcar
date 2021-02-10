package javaracingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    void generateCarWithName_null() {
        assertThatThrownBy(() -> Car.generateCar(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    @DisplayName("공백으로 구성된 이름 차 생성")
    void generateCarWithName_Space() {
        assertThatThrownBy(() -> Car.generateCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈된 문자열");
        assertThatThrownBy(() -> Car.generateCar("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    @DisplayName("정상 길이의 이름 차 새성")
    void generateCarWithName_ValidLength() {
        Car car = Car.generateCar("Benz");
        assertEquals(car.getName(), "Benz");
    }

    @Test
    @DisplayName("최대길이 초과 이름 차 생성")
    void generateCarWithName_OverLengthLimit() {
        assertThatThrownBy(() -> Car.generateCar("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }

    @Test
    void move() {
        Car car = new Car("Benz");
        car.move(4);
        assertEquals(car.getPosition(), 1);
    }

    @Test
    void stop() {
        Car car = new Car("Benz");
        car.move(3);
        assertEquals(car.getPosition(), 0);
    }
}