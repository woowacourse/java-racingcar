package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceTest {

    @Test
    @DisplayName("increaseDistance() : 이동거리 증가 테스트")
    void test_increaseDistance() {
        // given
        int defaultDistance = 0;
        int expectedDistance = defaultDistance + 1;

        Distance distance = new Distance(defaultDistance);

        // when
        distance.increaseDistance();

        // then
        assertThat(distance.getDistance()).isEqualTo(expectedDistance);
    }
}
