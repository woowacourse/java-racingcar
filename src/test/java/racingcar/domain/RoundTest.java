package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {
    // TODO - 질문
//    @Test
//    public void 시도할_횟수는_숫자여야한다() {
//        assertThatThrownBy(() -> {
//            Round.of("a");
//        }).isInstanceOf(Exception.class);
//    }

    @ParameterizedTest(name = "시도할_횟수는_1이상의_숫자여야_한다")
    @ValueSource(ints = {0, -1, -5})
    public void roundCountRangeTest(int count) {
        assertThatThrownBy(() -> {
            Round.of(count);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
