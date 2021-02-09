package racingcar;

import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자이하여야하며 빈칸은 허용하지 않는다.")
    @ValueSource(strings = {" ", "abcdefg", "  "})
    void createCarExceptionTest(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Car(name));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));
        assertThat(e.getMessage()).isEqualTo(Car.CAR_NAME_INVALID);
    }

    @ParameterizedTest
    @DisplayName("값에 따라 자동차가 움직이거나 움직이지 않는다.")
    @CsvSource(value = {"0:0", "1:0", "2:0", "4:1", "7:1", "9:1"}, delimiter = ':')
    void moveCarTest(String value, String position) {
        Car car = new Car("pika");
        car.movePosition(Integer.parseInt(value));
        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(position));
    }

    /*
    * 자동차 테스트 위에 것과 아래 것 어떤 것이 더 나은가요?
    * 저희 생각은 CsvSource를 쓴 위의 테스트코드가 중복이 없어 더 깔끔하다고 느끼나 가독성이 떨어진다고 생각하고
    * 아래의 테스트 코드는 중복이 있으나 가독성이 위의 테스트 코드보다는 좋다고 생각합니다.
    */
//    @ParameterizedTest
//    @DisplayName("랜덤 값이 3이하면 정지한다.")
//    @ValueSource(ints = {0, 1, 2, 3})
//    void stopCarTest(int number) {
//        Car car = new Car("pika");
//        car.movePosition(number);
//        assertThat(car.getPosition()).isEqualTo(0);
//    }
//
//    @ParameterizedTest
//    @DisplayName("랜덤 값이 4이상이면 움직인다.")
//    @ValueSource(ints = {4, 6, 9})
//    void moveCarTest(int number) {
//        Car car = new Car("pika");
//        car.movePosition(number);
//        assertThat(car.getPosition()).isEqualTo(1);
//    }
}
