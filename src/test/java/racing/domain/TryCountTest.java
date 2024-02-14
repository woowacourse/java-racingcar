package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    @Test
    @DisplayName("정상적으로 TryCount를 생성합니다.")
    void createTryCount(){
        assertDoesNotThrow(()->new TryCount("5"));
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닌 경우 예외")
    void createTryCountWithNonNumber(){
        assertThatThrownBy(()->new TryCount("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}