package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TrialCountTest {
    @Test
    @DisplayName("숫자는 음수가 될 수 없다.")
    void validatePositive() {
        int number = -1;
        assertThatThrownBy(() -> new TrialCount(number)).isInstanceOf(IllegalArgumentException.class);
    }
}