import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.CarLocation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarLocationTest {

    @DisplayName("생성자에서 음수값 입력에 대한 예외 발생 확인")
    @Test
    void constructor() {
        assertThatThrownBy(() -> new CarLocation(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("위치가 정상적으로 증가함을 확인")
    @Test
    void checkIncrease() {
        CarLocation carLocation = new CarLocation(0);

        carLocation.increaseLocation();

        Assertions.assertThat(carLocation.getLocation()).isEqualTo(1);
    }
}
