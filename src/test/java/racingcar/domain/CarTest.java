package racingcar.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domian.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    void 생성된_랜덤값이_4이상이면_이동한다(int inputValue, boolean expected) {
        Car car = new Car();
        Car expectedCar = new Car(1);
        car.move(inputValue);
        assertThat(car.equals(expectedCar)).isEqualTo(expected);
    }

}
