package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private RacingCar createInitCar() {
        Name name = new Name("name");
        return new RacingCar(name);
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이 되어야 한다.")
    void racingCarDefaultPosition() {
        RacingCar car = createInitCar();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 1칸 움직이거나 멈출 수 있다.")
    void racingCarMove() {
        RacingCar car = createInitCar();
        assertThat(car.move()).isIn(0, 1);
    }

    @Test
    @DisplayName("자동차의 위치를 비교한다.")
    void compareCarPosition() {
        RacingCar car = createInitCar();
        assertTrue(car.comparePosition(0));
    }
}
