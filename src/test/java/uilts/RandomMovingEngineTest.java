package uilts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RandomMovingEngine;

import static org.assertj.core.api.Assertions.*;

class RandomMovingEngineTest {

    @DisplayName("난수의 범위는 0 이상 9 이하이다.")
    @Test
    public void randomNumberRangeTest() {
        int randomPower = new RandomMovingEngine().generatePower();

        assertThat(randomPower).isLessThanOrEqualTo(9)
                .isGreaterThanOrEqualTo(0);
    }
}