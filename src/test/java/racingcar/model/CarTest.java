package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;

class CarTest {

    @Test
    void moveTest() {
        Car car = new Car("자동차1");

        car.move();

        assertThat(car.getProgress()).isEqualTo(1);
    }

    @DisplayName("이름이 5글자를 초과할 경우 예외를 발생한다.")
    @Test
    void exceededCarNameTest() {
        String name = "메르세데스벤츠";
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 빈 문자열이 입력될 경우 예외를 발생한다.")
    @Test
    void emptyCarNameTest() {
        String name = "";
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름에 공백이 입력될 경우 예외를 발생한다.")
    @Test
    void blankCarNameTest() {
        String name = " ";
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }
}