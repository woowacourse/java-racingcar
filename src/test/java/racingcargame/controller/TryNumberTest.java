package racingcargame.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TryNumberTest {
    @Test
    void 생성값이_0이하의_값이_들어오면_예외_처리() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new TryNumber(0));
    }

    @Test
    void 한라운드당_tryNumber1_감소처리() {
        TryNumber tryNumber = new TryNumber(1);
        tryNumber.reduce();
        assertThat(tryNumber).hasFieldOrPropertyWithValue("tryNumber", 0);
    }

    @Test
    void 남은_number가_0이_아닌지_검사() {
        TryNumber tryNumber1 = new TryNumber(1);
        TryNumber tryNumber2 = new TryNumber(2);
        tryNumber1.reduce();
        assertThat(tryNumber1.isNotZero()).isFalse();
        assertThat(tryNumber2.isNotZero()).isTrue();
    }
}
