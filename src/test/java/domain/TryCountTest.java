package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TryCountTest {

    @DisplayName("양의 정수를 입력 시 정상적으로 TryCount 인스턴스를 생성한다.")
    @Test
    void test1() {
        assertThatNoException().isThrownBy(() -> new TryCount(5));
    }

    @DisplayName("0이하의 정수를 입력 시 예외를 반환한다.")
    @Test
    void test2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new TryCount(-1));
    }
}