package domain;

import exception.NotNumberPositiveException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumberTest {

    @DisplayName("입력값이 양수가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -1, 0})
    public void testNotPositiveMoveCount(int tryNumber) {
        Assertions.assertThatThrownBy(() -> new TryNumber(tryNumber))
                .isInstanceOf(NotNumberPositiveException.class);
    }

    @DisplayName("시도횟수가 양수일 시 게임 진행 여부를 정확히 판별하는 지 테스트")
    @Test
    public void testTryGame() {
        TryNumber tryNumber = new TryNumber(4);
        Assertions.assertThat(tryNumber.isTryable()).isTrue();
    }

    @DisplayName("시도횟수가 음수일 시 게임 진행 여부를 정확히 판별하는 지 테스트")
    @Test
    public void testNotTryGame() {
        TryNumber tryNumber = new TryNumber(1);
        tryNumber.decrease();
        Assertions.assertThat(tryNumber.isTryable()).isFalse();
    }

}
