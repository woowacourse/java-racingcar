package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @DisplayName("이름이 5자가 넘어가는 자동차는 생성 검증에 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "9999999999999"})
    void testCreateCarWithInvalidLengthName(String carName) {
        assertThatThrownBy(() -> Car.of(carName, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자가 넘어가지 않는 자동차는 셍성 검증에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "123", "12"})
    void testCreateCarWithValidLengthName(String carName) {
        assertThatCode(() -> Car.of(carName, 0)).doesNotThrowAnyException();
    }

    @DisplayName("차는 움직임을 시도한 후 원래 자리에 멈춰있거나 한 칸 움직인다.")
    @Test
    void tryMoveThen() {
        Car car = Car.of("car", 0);
        car.tryMove();
        assertThat(car.getPosition()).isIn(List.of(0, 1));
    }
}