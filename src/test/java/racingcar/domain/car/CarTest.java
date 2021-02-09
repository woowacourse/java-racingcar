package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    Car testingCar = new Car("java");

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    @DisplayName("조건에 따른 한 칸 전진")
    void moveForward(int number, boolean result) {
        testingCar.move(number);
        assertEquals(testingCar.getPosition() == 1, result);
    }

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:True"}, delimiter = ':')
    @DisplayName("주어진 포지션에 있는지 여부 반환")
    void isPosition(int predictedPosition, boolean result) {
        testingCar.move(5);
        assertEquals(testingCar.isPosition(predictedPosition), result);
    }

    @Test
    @DisplayName("toString() 오버라이드")
    void testToString() {
        assertEquals("java", testingCar.toString());
    }
}