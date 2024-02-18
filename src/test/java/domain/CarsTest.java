package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Nested
    @DisplayName("자동차 생성 테스트")
    class CarGenerationTest {
        @DisplayName("자동차들이 성공적으로 생성된다.")
        @Test
        void success() {
            List<String> carNames = List.of(
                    "toby", "tebah", "anna"
            );
            assertDoesNotThrow(() -> Cars.from(carNames));
        }

        @DisplayName("자동차들의 이름이 중복되어 자동차 생성에 실패한다.")
        @Test
        void fail() {
            List<String> carNames = List.of(
                    "toby", "tebah", "anna", "brown", "brown"
            );
            assertThrows(IllegalArgumentException.class, () ->
                    Cars.from(carNames)
            );
        }
    }
}
