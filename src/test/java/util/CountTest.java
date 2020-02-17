package util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountTest {
    @Test
    @DisplayName("횟수를 양수로 하여 횟수(Count) 객체생성 시도")
    void createPositiveCount() {
        Assertions.assertThat(new Count(1).getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("횟수를 음수로 하여 횟수(Count) 객체생성 시도")
    void createNegativeCount() {
        Assertions.assertThatThrownBy(() -> new Count(-1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수를 0으로 하여 횟수(Count) 객체생성 시도")
    void createZeroCount() {
        Assertions.assertThatThrownBy(() -> new Count(0))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
