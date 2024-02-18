package domain;

import exception.NotNumberPositiveException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberTest {

    @DisplayName("입력값이 양수가 아니면 예외를 던진다.")
    @Test
    public void testNotPositiveMoveCount() {
        int notPositiveNumber = 0;

        Assertions.assertThatThrownBy(() -> new TryNumber(notPositiveNumber))
                .isInstanceOf(NotNumberPositiveException.class);
    }
}
