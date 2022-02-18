package racingcar.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Car 클래스를 테스트한다.")
class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car("a");
    }

    @Test
    @DisplayName("자동차가 앞으로 전진하는지 확인한다")
    void goForward() {
        int exPosition = car.getPosition();

        car.goForward(4);

        assertThat(exPosition + 1).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("자동차가 앞으로 전진하지 않는지 확인한다")
    void dontGoForward() {
        int exPosition = car.getPosition();

        car.goForward(3);

        assertThat(exPosition).isEqualTo(car.getPosition());
    }

    @Test
    @DisplayName("자동차가 우승자가 맞는지 확인한다")
    void isWinner() {
        car.goForward(4);
        boolean result = car.isSamePosition(1);

        assertThat(result).isTrue();
    }
}