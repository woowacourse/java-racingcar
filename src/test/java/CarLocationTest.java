import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.CarLocation;
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
}
