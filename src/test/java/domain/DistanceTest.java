package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DistanceTest {
    @Test
    @DisplayName("같은 거리 값을 갖는 객체인지 확인하다")
    void isSameDistance() {
        Distance distance = Distance.from(2);
        Distance otherDistance = Distance.from(2);
        Assertions.assertThat(distance.isSameDistance(otherDistance)).isTrue();
    }
}
