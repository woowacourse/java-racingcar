package racingcargame.model;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGameRaceCountTest {

    @Test
    @DisplayName("저장된 자동차 경주 횟수가 저장되었는지 확인")
    void storeRaceCount() {
        ImmovableRaceCount immovableRaceCount = new ImmovableRaceCount(4);
        immovableRaceCount.reduceRaceCount();

        assertThat(immovableRaceCount.isZeroRaceCount()).isFalse();
    }

    @Test
    @DisplayName("경주 횟수 감소 테스트")
    void reduceRaceCount() {
        ImmovableRaceCount immovableRaceCount = new ImmovableRaceCount(3);
        immovableRaceCount.reduceRaceCount();

        assertThat(immovableRaceCount.isZeroRaceCount()).isTrue();
    }
}