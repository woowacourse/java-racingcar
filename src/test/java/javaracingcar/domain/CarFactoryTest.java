package javaracingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void generateCarWithName_null() {
        assertThatThrownBy(() -> CarFactory.generateCar(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void generateCarWithName_공백() {
        assertThatThrownBy(() -> CarFactory.generateCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
        assertThatThrownBy(() -> CarFactory.generateCar("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    void generateCarWithName_최대길이이하() {
        Car car = CarFactory.generateCar("Benz");
        assertEquals(car.getName(), "Benz");
    }

    @Test
    void generateCarWithName_최대길이초과() {
        assertThatThrownBy(() -> CarFactory.generateCar("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }
}