package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private Name name;

    @BeforeEach
    void setup() {
        name = new Name("name");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이 되어야 한다.")
    void racingCarDefaultPosition() {
        final RacingCar car = new RacingCar(name, () -> true);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 이동가능할 경우 1칸 움직일 수 있다..")
    void racingCarMove() {
        final RacingCar car = new RacingCar(name, () -> true);
        assertThat(car.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 이동 불가능할 경우 멈춰있는다.")
    void racingCarNotMove() {
        final RacingCar car = new RacingCar(name, () -> false);
        assertThat(car.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 위치를 비교한다.")
    void compareCarPosition() {
        final RacingCar car = new RacingCar(name, () -> true);
        assertTrue(car.comparePosition(0));
    }
}
