import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {
    @DisplayName("자동차 생성 성공 테스트")
    @Test
    void carGenerateTest() {
        assertThatCode(() -> new Car("테스트")).doesNotThrowAnyException();
    }

}