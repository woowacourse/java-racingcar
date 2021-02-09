package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차의 이름을 null 또는 빈문자로 주었을 경우")
    void car_이름_null_또는_빈문자() {
        String carName = "";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 한글 혹은 영어로 이루어지지 않은 경우")
    void car_이름_한글_영어_이외() {
        String carName = "ㅏㅁ*7";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차의 이름의 길이가 5 초과인 경우")
    void car_이름_길이_5_초과() {
        String carName = "pobbbbbbi";
        assertThatThrownBy(() -> {
            Car car = new Car(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("주어진 값이 4 이하일 경우 움직이지 않음 확인")
    void carMoveRandomNumber_3(int randomNumber) {
        Car car = new Car("pobi");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 9})
    @DisplayName("주어진 값이 4 이상일 경우 움직임 확인")
    void carMoveRandomNumber_4(int randomNumber) {
        Car car = new Car("pobi");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
