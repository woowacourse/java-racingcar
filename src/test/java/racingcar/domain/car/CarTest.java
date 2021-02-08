package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"java:True", "python:False"}, delimiter = ':')
    @DisplayName("Car 인스턴스의 이름의 제한조건인 5자 이상인 경우 false 테스트")
    void checkMaxName(String input, boolean result) {
        Car testingCar = new Car(input);
        assertEquals(Car.checkMaxName(testingCar), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:False", "1:False", "3:False", "4:True", "9:True"}, delimiter = ':')
    @DisplayName("조건에 따른 Car 인스턴스의 전진 테스트")
    void tryToMoveForward(int randomInteger, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(randomInteger);
        assertEquals(testingCar.getPosition() == 1, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:False", "1:True"}, delimiter = ':')
    @DisplayName("maxPosition과 Car 객체의 position 비교 테스트")
    void isMaxPosition(int maxPosition, boolean result) {
        Car testingCar = new Car("java");
        testingCar.tryToMoveForward(5);
        assertEquals(testingCar.isMaxPosition(maxPosition), result);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:'java : '", "1:'java : -'", "2:'java : --'"}, delimiter = ':')
    @DisplayName("format에 맞게 return값이 나오는지 테스트")
    void testFormatSingleRoundInformation(int position, String result) {
        Car testingCar = new Car("java");
        for (int i = 0; i < position; ++i) {
            testingCar.tryToMoveForward(5);
        }
        assertEquals(testingCar.formatSingleRoundInformation(), result);
    }
}