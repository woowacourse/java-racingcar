package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @DisplayName("양의 정수를 입력 시 정상적으로 TryCount 인스턴스를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void create_success(int rightInput) {
        assertThatNoException().isThrownBy(() -> new TryCount(rightInput));
    }

    @DisplayName("0이하의 정수를 입력 시 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {-100, -1, 0})
    void create_fail(int wrongInput) {
        assertThatThrownBy(() -> new TryCount(wrongInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}