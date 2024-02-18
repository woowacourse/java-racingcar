package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "ABCDE"})
    @DisplayName("정상적인 자동차 이름 경계값 테스트")
    void valid_car_name_test(String carName) {
        assertThatCode(() -> new Car(carName))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "ABCDEF"})
    @DisplayName("비정상적인 자동차 이름 경계값 테스트")
    void invalid_car_name_test(String carName) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Car(carName));
    }
}
