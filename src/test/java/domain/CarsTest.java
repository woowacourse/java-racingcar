package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.RandomFailPowerMaker;
import util.RandomSuccessPowerMaker;

class CarsTest {

    private final RandomSuccessPowerMaker randomSuccessPowerMaker = new RandomSuccessPowerMaker();
    private final RandomFailPowerMaker randomFailPowerMaker = new RandomFailPowerMaker();

    @Test
    @DisplayName("moveAll() : 자동차가 모두 움직인다.")
    void test_moveAll_success() {
        // given
        int defaultDistance = 0;
        int expectedDistanceAfterMoveSuccess = defaultDistance + 1;

        Car pobi = new Car("pobi", defaultDistance);
        Car crong = new Car("crong", defaultDistance);
        Cars cars = new Cars(List.of(pobi, crong));

        // when
        cars.moveAll(randomSuccessPowerMaker);

        // then
        assertThat(pobi.getDistance()).isEqualTo(expectedDistanceAfterMoveSuccess);
        assertThat(crong.getDistance()).isEqualTo(expectedDistanceAfterMoveSuccess);
    }

    @Test
    @DisplayName("moveAll() : 자동차가 모두 움직이지 않는다.")
    void test_moveAll_fail() {
        // given
        int defaultDistance = 0;
        int expectedDistanceAfterMoveSuccess = defaultDistance + 1;

        Car pobi = new Car("pobi", defaultDistance);
        Car crong = new Car("crong", defaultDistance);
        Cars cars = new Cars(List.of(pobi, crong));

        // when
        cars.moveAll(randomFailPowerMaker);

        // then
        assertThat(pobi.getDistance()).isNotEqualTo(expectedDistanceAfterMoveSuccess);
        assertThat(crong.getDistance()).isNotEqualTo(expectedDistanceAfterMoveSuccess);
    }

    @Test
    @DisplayName("test_getWinnerNames() : 가장 많이 움직인 자동차를 반환해준다.")
    void test_getWinnerNames() {
        // given
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 1);

        Cars cars = new Cars(List.of(pobi, crong));

        // when
        List<String> winnerNames = cars.getWinnerNames();

        // then
        assertThat(winnerNames).containsOnly(pobi.getName());
        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames).doesNotContain(crong.getName());
    }

    @Test
    @DisplayName("getCurrentRacingStatus() : 현재 움직인 거리를 보여준다.")
    void test_getCurrentRacingStatus() {
        // given
        Car pobi = new Car("pobi", 2);
        Car crong = new Car("crong", 1);
        Cars cars = new Cars(List.of(pobi, crong));

        // when
        Map<String, Integer> carCurrentStatus = cars.getCurrentRacingStatus();

        // then
        assertThat(carCurrentStatus).hasSize(2)
                .contains(entry("pobi", 2), entry("crong", 1));
    }
}
