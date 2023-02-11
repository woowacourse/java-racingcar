package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("이동 횟수가 ")
class MoveCountTest {

    @ParameterizedTest(name = "1 미만이거나 10억 초과면 예외 발생")
    @ValueSource(strings = {"", "applej", "0", "1000000001"})
    void fail(String input) {
        assertThatThrownBy(() -> new MoveCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "1 ~ 10억이면 정상 동작")
    @ValueSource(strings = {"1", "1000000000"})
    void success(String input) {
        assertThatNoException().isThrownBy(() -> new MoveCount(input));
    }

    @DisplayName("decrease하면 count를 1 감소시킨다.")
    @Test
    void decreaseTest() {
        MoveCount moveCount = new MoveCount("1");
        moveCount.decrease();
        assertThat(moveCount.getCount()).isEqualTo(0);
    }

    @ParameterizedTest(name = "값이 0일 때만 isOver이 true이다.")
    @CsvSource({"1,true", "2,false"})
    void isOverTest(String count, Boolean expected) {
        MoveCount moveCount = new MoveCount(count);
        moveCount.decrease();
        assertThat(moveCount.isOver()).isEqualTo(expected);
    }
}