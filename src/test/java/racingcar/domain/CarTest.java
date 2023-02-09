package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.RacingCarStatusResponse;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("mycar");
    }

    @Test
    @DisplayName("차를 움직였을 때 위치가 변해야 한다.")
    void car_move() {
        // given
        RacingCarStatusResponse status = car.getStatus();
        car.move();
        RacingCarStatusResponse postStatus = car.getStatus();

        // expect
        assertThat(postStatus.getPosition())
                .isGreaterThan(status.getPosition());
    }

    @Test
    @DisplayName("차의 정보가 정확하게 반환되어야 한다.")
    void car_status() {
        // given
        car.move();
        car.move();

        // when
        RacingCarStatusResponse status = car.getStatus();

        // then
        assertThat(status.getPosition())
                .isEqualTo(2);
        assertThat(status.getName())
                .isEqualTo("mycar");
    }

    @ParameterizedTest
    @DisplayName("공백인 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = {" ", "", "\n", "    "})
    void validate_blankCarName(String input) {
        // expected
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @DisplayName("6글자 이상인 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = {"asgeiwsje", "fjeiwk", "djskfjq", "qqqqqqqqq"})
    void validate_outOfLengthCarName(String input) {
        // expected
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_CAR_NAME_LENGTH.getMessage());
    }
}
