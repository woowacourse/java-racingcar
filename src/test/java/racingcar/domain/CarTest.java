package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("Mery");
    }

    @Test
    @DisplayName("정상적으로 차가 움직이는지 확인한다.")
    void move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 정지했을 때 position에 변화가 없는지 확인한다.")
    void moveFail() {
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest(name = "name : {0}")
    @DisplayName("이름 길이가 1보다 작거나 5보다 큰 경우 예외를 발생시키는지 확인한다.")
    @NullAndEmptySource
    @ValueSource(strings = {"merrrrrrry", "pooooooobi", "pooooo"})
    void makeCars(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(name));
    }
}