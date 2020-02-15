package racingcargame.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TryNumberTest {
    @Test
    void 생성값이_0이하의_값이_들어오면_예외_처리() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryNumber("0"));
    }
}
