package domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Count;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountTest {

    @Test
    @DisplayName("횟수가 남은 경우를 확인한다.")
    void isExits_true() {
        Count count = Count.from(1);

        assertThat(count.isExits()).isTrue();
    }

    @Test
    @DisplayName("횟수가 남지 않은 경우를 확인한다.")
    void isExits_false() {
        Count count = Count.from(1);

        count.increase();

        assertThat(count.isExits()).isFalse();
    }
}