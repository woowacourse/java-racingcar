package racingcar.model.track;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.TestDataManager;
import racingcar.exception.InvalidRangeTrialTimesException;
import racingcar.exception.InvalidTrialTimesFormatException;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.car.strategy.ForwardMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrackTest {
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외 처리가 되는지 테스트")
    @Test
    void validateTrialTimesFormatTest() {
        Car pobi = new Car("pobi", new ForwardMovingStrategy());

        assertThatThrownBy(() -> {
            new Track(new Cars(List.of(pobi)), "a");
        }).isInstanceOf(InvalidTrialTimesFormatException.class);
    }

    @DisplayName("시도 횟수가 범위보다 작을 경우 예외 처리가 되는지 테스트")
    @Test
    void validateUnderMinRangeTrialTimesTest() {
        Car pobi = new Car("pobi", new ForwardMovingStrategy());

        assertThatThrownBy(() -> {
            new Track(new Cars(List.of(pobi)), "0");
        }).isInstanceOf(InvalidRangeTrialTimesException.class);
    }

    @DisplayName("시도 횟수가 범위보다 클 경우 예외 처리가 되는지 테스트")
    @Test
    void validateExceedMaxRangeTrialTimesTest() {
        Car pobi = new Car("pobi", new ForwardMovingStrategy());

        assertThatThrownBy(() -> {
            new Track(new Cars(List.of(pobi)), "101");
        }).isInstanceOf(InvalidRangeTrialTimesException.class);
    }

    @DisplayName("시도한 횟수만큼 진행하는지 확인하는 테스트")
    @Test
    void raceCarTest() {
        // given
        Cars cars = TestDataManager.getCarsTestData();
        String trialTime = "3";
        Track track = new Track(cars, trialTime);

        // when
        for (int i = 0; i <= Integer.parseInt(trialTime); i++) {
            track.race();
        }

        // then
        assertThat(track.runnable()).isFalse();
    }
}
