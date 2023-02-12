package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"}, delimiter = ',')
    @DisplayName("power 값에 따른 이동 여부 확인 테스트")
    void moveTest(int power, int expectPosition) {
        Car car = new Car("jerry");
        car.move(power);
        Assertions.assertEquals(car.getPosition(), expectPosition);
    }
}