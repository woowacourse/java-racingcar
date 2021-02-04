package javaracingcar.controller;

import javaracingcar.controller.CarGenerator;
import javaracingcar.domain.Car;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    @Test
    void generateCarWithName_null() {
        assertThatThrownBy(() -> CarGenerator.generateCar(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }

    @Test
    void generateCarWithName_공백() {
        assertThatThrownBy(() -> CarGenerator.generateCar(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
        assertThatThrownBy(() -> CarGenerator.generateCar("   "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열");
    }

    @Test
    void generateCarWithName_최대길이이하() {
        Car car = CarGenerator.generateCar("Benz");
        assertEquals(car.getName(), "Benz");
    }

    @Test
    void generateCarWithName_최대길이초과() {
        assertThatThrownBy(() -> CarGenerator.generateCar("Tuscan"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최대길이를 초과");
    }
}