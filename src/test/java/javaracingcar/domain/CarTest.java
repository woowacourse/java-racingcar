package javaracingcar.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

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