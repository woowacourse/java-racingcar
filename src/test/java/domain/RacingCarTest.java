package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName("4이상이면 움직이고 3 이하이면 움직이지 않는다.")
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void moveTest(int value, int result){
        RacingCar car = new RacingCar("car"){
            @Override
            protected int getRandomInteger() {
                return value;
            }
        };

        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(result);
    }
}