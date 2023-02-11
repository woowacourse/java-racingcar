package racingcar.domain;

import static org.assertj.core.api.Assertions.*;
import static racingcar.exception.ExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.ExceptionMessage.ILLEGAL_POSITION;
import static racingcar.exception.ExceptionMessage.OUT_OF_CAR_NAME_LENGTH;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
        car.move();
        Position position = car.getPosition();

        // expect
        assertThat(position.getValue())
                .isGreaterThan(0);
    }

    @Test
    @DisplayName("차의 정보가 정확하게 반환되어야 한다.")
    void car_status() {
        // given
        Name name = car.getName();

        // expect
        assertThat(name.getValue())
                .isEqualTo("mycar");
    }

    @ParameterizedTest
    @DisplayName("공백인 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = {" ", "", "\n", "    "})
    void validate_blankCarName(String input) {
        // expect
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @DisplayName("6글자 이상인 자동차 이름이 검증되어야 한다.")
    @ValueSource(strings = {"asgeiwsje", "fjeiwk", "djskfjq", "qqqqqqqqq"})
    void validate_outOfLengthCarName(String input) {
        // expect
        assertThatThrownBy(() -> new Car(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_CAR_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("자동차 이름에 null 값이 주어지면 예외가 발생해야 한다.")
    void validate_null() {
        // expect
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @Test
    @DisplayName("자동차가 위치가 다르면 거짓이 반환되어야 한다.")
    void isSamePosition_false() {
        // given
        car.move();
        Position position = new Position(0);

        // expect
        assertThat(car.getPosition())
                .isNotEqualTo(position);
    }

    @Test
    @DisplayName("자동차가 위치가 같으면 참이 반환되어야 한다.")
    void isSamePosition_true() {
        // given
        car.move();
        Position position = new Position(1);

        // expect
        assertThat(car.getPosition())
                .isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, Integer.MIN_VALUE})
    @DisplayName("자동차를 생성할 때 위치 값이 음수이면 예외가 발생한다.")
    void car_NegativePosition(int input) {
        // expect
        assertThatThrownBy(() -> new Car("Glen", input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ILLEGAL_POSITION.getMessage());
    }
}
