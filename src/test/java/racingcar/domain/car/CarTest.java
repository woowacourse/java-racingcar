package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    Car car = new Car("java");

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    @DisplayName("조건에 따른 한 칸 전진")
    void moveForwardTest(int number, boolean result) {
        car.move(number);
        assertEquals(car.getPosition().equals(new Position(1)), result);
    }

    @Test
    @DisplayName("주어진 포지션에 있는지 여부 반환")
    void isPositionTest() {
        Car comparingCar = new Car("jason");
        car.move(5);
        assertFalse(car.inSamePosition(comparingCar));
    }

    @Test
    @DisplayName("Car equals 테스트")
    void equalsTest() {
        assertEquals(car, new Car("java"));
    }

    @Test
    @DisplayName("toString() 오버라이드")
    void toStringTest() {
        assertEquals("java", car.toString());
    }
}