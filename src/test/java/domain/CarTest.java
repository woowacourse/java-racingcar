package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import utils.constants.ErrorMessages;

class CarTest {

    @Test
    @DisplayName("Car 생성 테스트")
    void checkConstructor() {

        String expected = "test";
        Car car = new Car(expected);

        String result = car.getName();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Car 이름이 5글자 넘으면 예외발생")
    void checkFailTest() {
        assertThatThrownBy(() -> new Car("testTest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NAME_LENGTH.getMessage());
    }

    @ParameterizedTest(name = "move()의 인자로 3보다 큰 수가 들어오면 position이 증가한다. 입력값 = {0}")
    @CsvSource(value = {"4,1", "3,0"})
    void checkMoveTest(int randomNumber, int expected) {
        Car car = new Car("test");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}