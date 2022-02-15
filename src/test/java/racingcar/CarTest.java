package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("Car 생성 테스트 - name")
    @Test
    public void createCar_name() {
        String name = "bunny";
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("Car 생성 테스트 - position")
    @Test
    public void createCar_position() {
        String name = "bunny";
        Car car = new Car(name);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 에러 발생 ")
    @Test
    public void createCar_not_allow_length() {
        String name = "bunnies";

        assertThatThrownBy(() -> {
            new Car(name);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @DisplayName("자동차 이름이 0자 이하인 경우 에러 발생 ")
    @Test
    public void createCar_not_allow_minimum_length() {
        String name = "";

        assertThatThrownBy(() -> {
            new Car(name);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상만 가능합니다.");
    }

    @DisplayName("자동차 이름에 공백이 입력되는 경우 에러 발생 ")
    @Test
    public void createCar_not_allow_space() {
        String name = "b nny";

        assertThatThrownBy(() -> {
            new Car(name);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름에 공백 입력은 불가능합니다.");
    }

    @DisplayName("Car 이동 테스트 - TRUE")
    @Test
    public void movePosition_Ture() {
        String name = "bunny";
        Car car = new Car(name);

        car.movePosition(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("Car 이동 테스트 - FALSE")
    @Test
    public void movePosition_False() {
        String name = "bunny";
        Car car = new Car(name);

        car.movePosition(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car 우승자 계산 테스트 - TRUE")
    @Test
    public void carMaxPosition_True() {
        String name = "bunny";
        Car car = new Car(name);

        car.movePosition(true);
        car.movePosition(true);
        car.movePosition(true);

        assertThat(car.isMaxPosition(3)).isEqualTo(true);
    }

    @DisplayName("Car 우승자 계산 테스트 - FALSE")
    @Test
    public void carMaxPosition_False() {
        String name = "bunny";
        Car car = new Car(name);

        car.movePosition(true);
        car.movePosition(true);
        car.movePosition(false);

        assertThat(car.isMaxPosition(3)).isEqualTo(false);
    }

    @DisplayName("Car 이동할 수 있는지 테스트 - TRUE")
    @Test
    public void carMovable_True() {
        String name = "bunny";
        Car car = new Car(name);

        boolean isMove = car.isMovable(5);
        car.movePosition(isMove);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("Car 이동할 수 있는지 테스트 - FALSE")
    @Test
    public void carMovable_False() {
        String name = "bunny";
        Car car = new Car(name);

        boolean isMove = car.isMovable(3);
        car.movePosition(isMove);

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
