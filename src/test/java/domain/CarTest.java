package domain;

import domain.car.Car;
import domain.car.MovableEngine;
import domain.car.StuckEngine;
import domain.name.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    @DisplayName("이름을 받아 자동차를 생성한다")
    void createCar() {

        //Given
        Name name = new Name("kim");

        //When
        Car car = new Car(name);
        //Then
        assertInstanceOf(Car.class, car);
    }

    @DisplayName("4 이상이면 위치를 한 칸 전진한다.")
    public void forwardPositionWhenNumberIsGreaterThan4() {
        Car car = new Car(new Name("kim"));

        car.race(new MovableEngine());

        assertEquals(car.getPosition(), car.getPosition() + 1);
    }

    @DisplayName("4 미만이면 위치는 변하지 않는다.")
    public void stayPositionWhenNumberIsUnderThan4() {
        Car car = new Car(new Name("kim"));

        car.race(new StuckEngine());

        assertEquals(car.getPosition(), car.getPosition());
    }
}
