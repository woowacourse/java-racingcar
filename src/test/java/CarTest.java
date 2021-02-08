import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @ParameterizedTest
    @DisplayName("자동차 이름은 5글자이하여야하며 빈칸은 허용하지 않는다.")
    @ValueSource(strings = {" ", "abcdefg", "  "})
    void createCarExceptionTest(String name){
        assertThrows(IllegalArgumentException.class, ()-> new Car(name));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Car(name));
        assertThat(e.getMessage()).isEqualTo(Car.CAR_NAME_INVALID);
    }

    @Test
    @DisplayName("자동차가 제대로 이동하는지 확인한다.")
    void moveCarTest() {
        Car car = new Car("pika");
        car.movePosition();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자 생성기가 0에서 9사이의값을 가지는지 확인한다.")
    void getRandomTest() {
        Car car = new Car("pika");
        for(int i = 0; i < 100; i++) {
            car.getRandomNumber();
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
        }
    }
}
