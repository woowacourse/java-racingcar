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
    @DisplayName("자동차의 초기 위치는 0이 되어야 한다.")
    void racingCarDefaultPosition() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 위치를 비교한다.")
    void compareCarPosition() {
        assertTrue(car.compareTo(new RacingCar("abc")) == 0);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름은 null 이거나 비어있을 수 없다.")
    void checkRacingCarNameNullOrEmpty(String nullOrEmptyInput) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new RacingCar(nullOrEmptyInput))
            .withMessageMatching("자동차 이름은 비어있을 수 없다.");
    }

}
