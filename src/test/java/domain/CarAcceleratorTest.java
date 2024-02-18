package domain;

import domain.accelerator.Accelerator;
import domain.accelerator.strategy.RandomMoveAccelerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarAcceleratorTest {

    @Test
    @DisplayName("엑셀을 push하면 0~9 사이의 값만 리턴한다")
    void return0To9WhenPushAccelerator() {
        //given
        Accelerator accelerator = new RandomMoveAccelerator();
        //when
        int actual = accelerator.push();
        //then
        assertThat(actual).isBetween(Accelerator.MIN_ACCEL_POWER, Accelerator.MAX_ACCEL_POWER);
    }
}