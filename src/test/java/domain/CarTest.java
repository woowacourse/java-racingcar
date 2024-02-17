package domain;

import domain.car.Car;
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

    @ParameterizedTest
    @DisplayName("4 이상이면 위치를 한 칸 전진한다.")
    @ValueSource(ints = {4, 5})
    public void forwardPositionWhenNumberIsGreaterThan4(Integer value) {
        Car car = new Car(new Name("kim"));
        Integer pos = car.getPosition();

        car.race(value);

        assertEquals(car.getPosition(), pos + 1);
    }
}
