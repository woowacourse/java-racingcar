package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    @Test
    @DisplayName("정상적으로 TryCount를 생성합니다.")
    void createTryCount(){
        assertDoesNotThrow(()->new TryCount(5));
    }
}