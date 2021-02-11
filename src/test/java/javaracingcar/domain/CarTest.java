package javaracingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    Car car;

    @BeforeEach
    void setup() {
        car = new Car("Benz");
    }


    @ParameterizedTest
    @ValueSource(ints={4,5,7,9})
    void move() {
        car.move(4);
        assertEquals(car.getPosition(), 1);
    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2,3})
    void stop() {
        car.move(3);
        assertEquals(car.getPosition(), 0);
    }

    @Test
    void isAtPosition() {
        assertTrue(car.isAtPosition(0));
        car.move(4);
        assertTrue(car.isAtPosition(1));
    }
}