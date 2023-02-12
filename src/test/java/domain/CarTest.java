package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.fail;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import validation.ErrorMessages;
import validation.exception.InvalidCarNameException;

class CarTest {

    @DisplayName("자동차 이름이 null일 경우 오류를 던진다.")
    @Test
    void create_fail_name_null() {
        //given
        //when then
        assertThatThrownBy(() -> {
            Car car = new Car(null, 0);
        }).isExactlyInstanceOf(InvalidCarNameException.class)
            .hasMessage(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차 이름이 빈문자열일 경우 오류를 던진다.")
    @Test
    void create_fail_name_empty() {
        //given
        //when then
        assertThatThrownBy(() -> {
            Car car = new Car("", 0);
        }).isExactlyInstanceOf(InvalidCarNameException.class)
            .hasMessage(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차 이름이 5자 이상일 경우 오류를 던진다.")
    @Test
    void create_fail_name_too_long() {
        //given
        //when then
        assertThatThrownBy(() -> {
            Car car = new Car("123456", 0);
        }).isExactlyInstanceOf(InvalidCarNameException.class)
            .hasMessage(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
    }

    @DisplayName("자동차 이름이 적절한 경우")
    @Test
    void create_success() {
        try {
            Car car = new Car("valid", 0);
        } catch (Exception e) {
            fail("정상적으로 자동차를 생성해야 합니다.");
        }
    }

    @DisplayName("자동차를 전진 시킨다.")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void 차량_전진_테스트(int driveCount) {
        //given
        final int drivingDistance = 1;
        Car car = new Car("valid", 0);
        //when
        IntStream.range(0, driveCount).map(count -> drivingDistance).forEach(car::drive);
        //then
        int drivenDistance = car.getDrivenDistance();
        assertThat(drivenDistance).isEqualTo(driveCount);
    }
}
