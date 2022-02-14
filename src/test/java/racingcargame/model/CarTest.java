package racingcargame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("입력된 자동차 이름이 없는 경우 테스트")
    @Test
    void checkValidateName_EmptyName() {
        String name = "";
        int position = 3;

        assertThatThrownBy(() -> {
            Car car = new Car(name, position);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력된 자동차 이름중 이름이 없는 자동차가 있습니다.");
    }

    @DisplayName("자동차 이름에 빈칸이 입력되는 경우 테스트")
    @Test
    void checkValidateName_HasBlank() {
        String name = "토 미 ";
        int position = 3;

        assertThatThrownBy(() -> {
            Car car = new Car(name, position);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력한 자동차 이름에 공백이 있습니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 테스트")
    @Test
    void checkValidateName_ValidNameLength() {
        String name = "토미데이비슨";
        int position = 3;

        assertThatThrownBy(() -> {
            Car car = new Car(name, position);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 자동차 이름을 5자 이하로 입력해주세요.");
    }

    @DisplayName("Car 객체가 정상적으로 생성되는지 테스트")
    @Test
    void car_objectCreate() {
        String name = "토미";
        int position = 3;
        Car car = new Car(name, position);

        assertThat(car.getName()).isEqualTo("토미");
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @DisplayName("난수값에 따라 자동차의 position값이 바뀌는지 테스트")
    @Test
    void moveCar() {
        String name = "토미";
        int position = 3;
        Car car = new Car(name, position);

        int moveNumber = car.moveCar();

        if (moveNumber >= 4) {
            assertThat(car.getPosition()).isEqualTo(4);
        }
        if (moveNumber < 4) {
            assertThat(car.getPosition()).isEqualTo(3);
        }
    }
}
