package racingcar.model.track;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.model.car.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {
    @DisplayName("시도한 횟수만큼 진행하는지 확인하는 테스트")
    @Test
    void raceCarTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();
        int trialTime = 3;
        Track track = new Track(cars, trialTime);

        // when
        for (int i = 0; i <= trialTime; i++) {
            track.race();
        }

        // then
        assertThat(track.runnable()).isFalse();
    }

}
