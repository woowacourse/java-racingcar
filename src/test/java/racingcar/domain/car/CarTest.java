package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    @DisplayName("조건에 따른 한 칸 전진")
    void tryToMoveForward(int randomInteger, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(randomInteger);
        assertEquals(testingCar.getPosition() == 1, result);
    }

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:True"}, delimiter = ':')
    @DisplayName("주어진 포지션에 있는지 여부 반환")
    void isMaxPosition(int maxPosition, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(5);
        assertEquals(testingCar.isMaxPosition(maxPosition), result);
    }

    @Test
    @DisplayName("toString() 오버라이드")
    void testToString() {
        Car testingCar = new Car("java");
        for (int i = 0; i < 3; ++i) {
            testingCar.tryToMoveForward(5);
        }
        assertEquals("java : ---", testingCar.toString());
    }
}