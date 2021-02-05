package racingcar.domain.trynumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {

    @DisplayName("TryNumber 객체를 생성하는 기능 ")
    @Test
    void testInitTryNumber() {
        //given
        int tryNumberValue = 3;

        //when
        TryNumber tryNumber = new TryNumber(tryNumberValue);

        //then
        assertThat(tryNumber.getTryNumber()).isEqualTo(tryNumberValue);
    }

    @DisplayName("시도횟수가 최소 시도횟수보다 작으면 예외를 발생시킨다")
    @Test
    void testInitTryNumberIfTryNumberValueLessThanMinTryNumberValue() {
        //given
        int tryNumber = 0;

        //when //then
        assertThatThrownBy(() -> new TryNumber(tryNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}