package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "jay", "jamie", "odo"})
    @DisplayName("생성자 이름 예외 테스트 : 성공 경우)")
    void test_car_constructor_success(String carName) {
        // when & then
        Car car = new Car(carName, 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"kokodak", "sunghaa"})
    @DisplayName("생성자 이름 예외 테스트 : 실패 경우 (이름이 5자 이상)")
    void test_car_constructor_fail_over_length_name(String carName) {
        // given
        String expectedMessage = "자동차 이름은 5자 이하로 작성해주세요.";

        // when & then
        assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    @DisplayName("생성자 이름 예외 테스트 : 실패 경우 (이름이 공백)")
    void test_car_constructor_fail_empty_name() {
        // given
        String carName = "";
        String expectedMessage = "자동차를 한 대 이상 작성해주세요.";

        // when & then
        assertThatThrownBy(() -> new Car(carName, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "5", "6"})
    @DisplayName("move() : 자동차의 이동 성공 테스트")
    void test_move_success(int givenPower) {
        // given
        int givenDistance = 0;
        int expectedDistance = givenDistance + 1;
        Car car = new Car("pobi", givenDistance);

        // when
        car.move(givenPower);

        // then
        assertThat(car.getDistance()).isEqualTo(expectedDistance);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3"})
    @DisplayName("move() : 자동차 이동 실패 테스트")
    void test_move_fail(int givenPower) {
        // given
        int givenDistance = 0;
        int expectedDistanceAfterMoveSuccess = givenDistance + 1;
        Car car = new Car("pobi", givenDistance);

        // when
        car.move(givenPower);

        // then
        assertThat(car.getDistance()).isNotEqualTo(expectedDistanceAfterMoveSuccess);
    }
}
