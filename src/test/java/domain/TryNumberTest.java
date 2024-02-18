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

}
