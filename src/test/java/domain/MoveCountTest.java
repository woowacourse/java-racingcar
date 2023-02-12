package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("이동 횟수가 ")
class MoveCountTest {

    @ParameterizedTest(name = "1 미만이거나 1000 초과면 예외 발생")
    @ValueSource(ints = {0, 1001, -4})
    void 범위가_1미만이거나_1000초과면_예외_발생(int count) {
        assertThatThrownBy(() -> new MoveCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도할 횟수는 1 ~ 1,000까지 입니다.");
    }

    @ParameterizedTest(name = "1 ~ 1000이면 정상 동작")
    @ValueSource(ints = {1, 1000})
    void 범위가_1이상_1000이하면_정상_동작(int count) {
        assertThatNoException().isThrownBy(() -> new MoveCount(count));
    }

    @DisplayName("decrease하면 count를 1 감소시킨다.")
    @Test
    void decrease_내부카운트_1감소() {
        MoveCount moveCount = new MoveCount(1);
        moveCount.decrease();

        assertThat(moveCount.getCount()).isEqualTo(0);
    }

    @ParameterizedTest(name = "값이 0일 때만 isFinished가 true이다.")
    @CsvSource({"0,true", "1,false"})
    void isFinished_값이_0이면_true(int count, Boolean expected) {
        MoveCount moveCount = new MoveCount(count + 1);
        moveCount.decrease();

        assertThat(moveCount.isFinished()).isEqualTo(expected);
    }
}