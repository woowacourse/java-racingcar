package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("자동차 도메인 테스트")
class CarTest {

    @DisplayName("이름이 5자가 넘어가는 자동차는 생성 검증에 실패한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567", "9999999999999"})
    void testCreateCarWithInvalidLengthName(String carName) {
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5자가 넘어가지 않는 자동차는 셍성 검증에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "123", "12"})
    void testCreateCarWithValidLengthName(String carName) {
        assertThatCode(() -> Car.from(carName)).doesNotThrowAnyException();
    }
}