package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp() {
        car = new RacingCar("name");
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
    @DisplayName("자동차의 위치를 비교한다.")
    void compareCarPosition() {
        assertTrue(car.isSamePosition(new RacingCar("abc")));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 null 이거나 비어있을 수 없다.")
    void checkRacingCarNameNullOrEmpty(String nullOrEmptyInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar(nullOrEmptyInput))
            .withMessageMatching("자동차 이름은 비어있을 수 없다.");
    }

    @Test
    @DisplayName("움직일 수 있는 상황이면, 자동차가 움직인다.")
    void checkCanMove() {
        MovingStrategy movingStrategy = () -> true;
        if(movingStrategy.isMovable()) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("움직일 수 없는 상황이면, 자동차가 움직이지 않는다.")
    void checkNotMove() {
        MovingStrategy movingStrategy = () -> false;
        if(movingStrategy.isMovable()) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
