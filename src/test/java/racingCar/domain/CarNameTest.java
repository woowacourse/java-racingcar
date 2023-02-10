package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 이름이")
class CarNameTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생")
    void carNameTest_fail1() {
        String carName = "aaaaaa";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Car(carName, 0);
        });
    }

    @Test
    @DisplayName("자동차 이름을 올바르게 생성한 경우")
    void carNameTest_success() {
        String carName = "aaa";

        assertThatNoException().isThrownBy(() -> {
            new Car(carName, 0);
        });
    }
}
