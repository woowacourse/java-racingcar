package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.TryNumber;

public class TryNumberTest {

    @Test
    @DisplayName("숫자가 잘 들어갔는지 테스트")
    void NumberEqualTest() {
        TryNumber tryNumber = new TryNumber(1);
        assertThat(tryNumber).isEqualTo(new TryNumber(1));
    }

    @Test
    @DisplayName("0 미만의 수가 들어갈때 에러")
    void validateTest() {
        assertThatThrownBy(() -> new TryNumber(-1)).
            isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 감소 테스트")
    void decreaseNumberTest() {
        TryNumber tryNumber = new TryNumber(3);
        assertThat(tryNumber.decreaseNumber()).isEqualTo(new TryNumber(2));
    }
}
