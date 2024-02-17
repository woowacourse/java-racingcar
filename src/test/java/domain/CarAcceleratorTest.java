package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarAcceleratorTest {

    @Test
    @DisplayName("엑셀을 push하면 0~9 사이의 값만 리턴한다")
    void return0To9WhenPushAccelerator() {
        //given
        CarAccelerator accelerator = new CarAccelerator();
        //when
        int actual = accelerator.push();
        //then
        assertThat(actual).isBetween(CarAccelerator.MIN_ACCEL_POWER, CarAccelerator.MAX_ACCEL_POWER);
    }
}