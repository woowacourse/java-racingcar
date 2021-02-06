package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value={"java:True", "python:False"}, delimiter = ':')
    @DisplayName("Car 인스턴스의 이름의 제한조건인 5자 이상인 경우 false 테스트")
    void checkMaxName(String input, boolean result) {
        Car testingCar = new Car(input);
        assertEquals(Car.checkMaxName(testingCar), result);
    }

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    @DisplayName("조건에 따른 Car 인스턴스의 전진 테스트")
    void tryToMoveForward(int randomInteger, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(randomInteger);
        assertEquals(testingCar.getPosition() == 1, result);
    }

    @ParameterizedTest
    @CsvSource(value={"0:False", "1:True"}, delimiter = ':')
    void isMaxPosition(int maxPosition, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(5);
        assertEquals(testingCar.isMaxPosition(maxPosition), result);
    }

    @Test
    void testToString() {
        Car testingCar = new Car("java");
        for (int i = 0; i < 3; ++i) {
            testingCar.tryToMoveForward(5);
        }
        assertEquals(testingCar.toString(), "java : ---");
    }
}