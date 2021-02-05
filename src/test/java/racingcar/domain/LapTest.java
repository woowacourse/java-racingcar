package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LapTest {
    @Test
    @DisplayName("횟수 생성 확인")
    public void lap_create() {
        Lap lap = new Lap("10");
        assertThat(lap.getLap()).isEqualTo(10);
    }
}