package racinggame;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        assertThatCode(() -> Car.from("이상"))
            .doesNotThrowAnyException();
    }
}
