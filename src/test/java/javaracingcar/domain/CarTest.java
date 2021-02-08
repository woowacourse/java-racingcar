package javaracingcar.domain;

import org.junit.jupiter.api.Test;

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
    void generateCarWithName_공백() {
        assertThatThrownBy(() -> Car.generateCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
        assertThatThrownBy(() -> Car.generateCar("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    void generateCarWithName_최대길이이하() {
        Car car = Car.generateCar("Benz");
        assertEquals(car.getName(), "Benz");
    }

    @Test
    void generateCarWithName_최대길이초과() {
        assertThatThrownBy(() -> Car.generateCar("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }
}