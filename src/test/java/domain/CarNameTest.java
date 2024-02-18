package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @DisplayName("자동차의 이름이 5자 이하여서 자동차가 성공적으로 생성된다.")
    @Test
    void carNameSuccessTest() {
        final String testCarName = "test";
        assertDoesNotThrow(() -> new CarName(testCarName));
    }

    @DisplayName("자동차의 이름이 5자 초과되어 자동차의 생성이 실패한다.")
    @Test
    void carNameFailTest() {
        final String testCarName = "포포포포포비";
        assertThrows(IllegalArgumentException.class, () -> new CarName(testCarName));
    }
}
