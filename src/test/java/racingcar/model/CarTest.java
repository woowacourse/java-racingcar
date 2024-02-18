package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Car;

class CarTest {

    @Test
    @DisplayName("자동차는 이동할때 1씩 전진한다.")
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

    @Test
    @DisplayName("특정 정수를 바탕으로 현재 전진 정도를 비교한다.")
    void isEqualToProgressTest() {
        Car noMoveCar = new Car("car1");
        Car moveCar = new Car("car2");

        moveCar.move();

        Assertions.assertThat(noMoveCar.isEqualToProgress(0)).isTrue();
        Assertions.assertThat(moveCar.isEqualToProgress(1)).isTrue();
    }
}