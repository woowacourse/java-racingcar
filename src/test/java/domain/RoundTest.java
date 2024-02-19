package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RoundTest {

    @DisplayName("시도횟수는 1회 이상이다.")
    @Test
    void validRoundCount(){
        int count = 1;
        Round round = new Round(1);
        assertThat(round.getCount()).isEqualTo(count);
    }

    @DisplayName("0 이하의 값을 입력하면 예외가 발생한다.")
    @Test
    void invalidRoundCount() {
        assertThatThrownBy(() -> new Round(0)).isInstanceOf(IllegalArgumentException.class);
    }

}
