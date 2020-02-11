package CarRacingGame;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingGameTest {

    @ParameterizedTest
    @DisplayName("이름이 올바른지 확인")
    @ValueSource(strings = {"abcdef", ""})
    void validateCorrectName(String name) {
        assertThatThrownBy(() -> {
            Car car = new Car(name);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 1자 이상 5자 이하로 해주세요.");
    }

    @Test
    @DisplayName("이름을 입력하지 않은 경우")
    void noNameInput() {
        assertThatThrownBy(() -> {
            Car car = new Car(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 null값이 될 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차가 4,5,6,7,8,9일 때 전진하는지")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void carGo(int random) {
        Car car = new Car("car");
        int originalPosition = car.getPosition();
        car.decideGoOrStop(random);
        assertThat(car.getPosition()).isEqualTo(originalPosition + 1);
    }

    @ParameterizedTest
    @DisplayName("자동차가 0,1,2,3일 때 멈춰있는지")
    @ValueSource(ints = {0, 1, 2, 3})
    void carStop(int random) {
        Car car = new Car("car");
        int originalPosition = car.getPosition();
        car.decideGoOrStop(random);
        assertThat(car.getPosition()).isEqualTo(originalPosition);
    }
}
