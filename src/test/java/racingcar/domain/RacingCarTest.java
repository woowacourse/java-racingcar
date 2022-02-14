package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = new RacingCar("name");
    }

    @Test
    @DisplayName("자동차 이름이 null이 들어올 경우 예외가 발생해야 한다.")
    void checkRacingCarNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar(null))
            .withMessageMatching("자동차 이름은 null이 들어올 수 없다.");
    }

    @Test
    @DisplayName("자동차의 이름이 공백이 들어올 경우 예외가 발생해야 한다.")
    void checkRacingCarEmpty() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar(""))
            .withMessageMatching("자동차 이름은 공백이 들어올 수 없다.");
    }

    @Test
    @DisplayName("자동차의 이름이 5자가 초과될 경우 예외가 발생해야 한다.")
    void checkRacingCarNameLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar("abcede"))
            .withMessageMatching("자동차 이름은 5자를 초과할 수 없다.");
    }

    @Test
    @DisplayName("자동차의 초기 위치는 0이 되어야 한다.")
    void racingCarDefaultPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 1칸 움직이거나 멈출 수 있다.")
    void racingCarMove() {
        assertThat(car.move()).isIn(0, 1);
    }

    @Test
    @DisplayName("자동차의 위치를 비교한다.")
    void compareCarPosition() {
        assertTrue(car.comparePosition(0));
    }
}
