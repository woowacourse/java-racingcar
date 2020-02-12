package racingcar.domain;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domian.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    void 생성된_랜덤값이_4이상이면_이동한다(int inputValue, boolean expected) {
        Car car = new Car("user");
        Car expectedCar = new Car(1, "user");
        car.move(inputValue);
        assertThat(car.equals(expectedCar)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,user1,''", "2,user2,''", "3,user3,user3"})
    void 우승자_찾기(int position, String name, String expected) {
        int max = 3;
        Car car = new Car(position, name);
        assertThat(car.findWinner(max)).isEqualTo(expected);
    }



}
